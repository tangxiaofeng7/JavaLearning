## 初见Reflection

### 普通的执行命令代码
```
public class _01_excute {

  public static void main(String[] args) throws IOException {
    //Runtime执行命令
    InputStream inputStream = Runtime.getRuntime().exec("whoami").getInputStream();

    //InputStream转String-（方法一）
    StringWriter output1 = new StringWriter();
    IOUtils.copy(inputStream, output1, "utf-8");
    System.out.println(output1);

    //InputStream转String-（方法二）
    String output2 = IOUtils.toString(inputStream, "utf-8");
    System.out.println(output2);
  }
}

```
result:
```
txf
```

### 反射Runtime执行命令代码

class.newInstance() 的作用就是调用这个类的无参构造函数
如果失败，原因可能会是：
1. 你使用的类没有无参构造函数
2. 你使用的类构造函数是私有的

Runtime 类的构造方法是私有的,可以通过 Runtime.getRuntime() 来获取到 Runtime 对象
```
public class _02_excute {

  public static void main(String[] args) throws Exception {
    Class clazz = Class.forName("java.lang.Runtime");
    clazz.getMethod("exec", String.class)
        .invoke(clazz.getMethod("getRuntime").invoke(clazz), "open -a Calculator.app");
  }
}

```
result:
```
mac系统弹出计算器
```

### 反射执行恶意类
恶意类
```
public class _03_EvilClass {
    static{
        Runtime runtime = Runtime.getRuntime();
        String[] command = {"open","-a","Calculator.app"};

        try {
            runtime.exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
```
反射方法
```
public class _03_EvilExcute {
    public void ref(String name) throws Exception {
      Class.forName(name);
    }
}
```
执行
```
public class _03_main {

  public static void main(String[] args) throws Exception {
    _03_EvilExcute excute = new _03_EvilExcute();
    //修改本地的恶意类
    excute.ref("com.txf.Reflection._03_EvilClass");
  }
}


```
result:
```
mac系统弹出计算器
```

### 反射ProcessBuilder执行命令代码

```
public class _04_excute_processbuilder {

  public static void main(String[] args) throws Exception {

    Class clazz = Class.forName("java.lang.ProcessBuilder");

    //使用反射来获取其构造函数，然后调用start() 来执行命令
    ((ProcessBuilder) clazz.getConstructor(List.class).newInstance(Arrays.asList("open", "-a", "Calculator.app"))).start();

    //上面的代码包含了强制类型转化，实际利用时一般无法正常运行,所以通过 getMethod("start") 获取到start方法，然后 invoke 执行
    clazz.getMethod("start").invoke(clazz.getConstructor(List.class).newInstance(Arrays.asList("open", "-a", "Calculator.app")));

    //调用 newInstance 的时候，因为这个函数本身接收的是一个可变长参数，传给ProcessBuilder 的也是一个可变长参数，二者叠加为一个二维数组
    ((ProcessBuilder) clazz.getConstructor(String[].class).newInstance(new String[][]{{"open", "-a", "Calculator.app"}})).start();

    //同理，改为反射如下
    clazz.getMethod("start").invoke(clazz.getConstructor(String[].class).newInstance(new String[][]{{"open", "-a", "Calculator.app"}}));

  }
}
```
result:
```
mac系统弹出计算器
```

### 反射私有方法

在获取到一个私有方法后，必须用 setAccessible 修改它的作用域
```
public class _05_excute_private {

  public static void main(String[] args) throws Exception {
    Class clazz = Class.forName("java.lang.Runtime");
    Constructor m = clazz.getDeclaredConstructor();
    m.setAccessible(true);
    clazz.getMethod("exec", String.class).invoke(m.newInstance(), "open -a Calculator.app");
  }
}
```
result:
```
mac系统弹出计算器
```
