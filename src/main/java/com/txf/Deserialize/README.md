## 初见反序列化
序列化：

将Java对象转换为字节流的过程，使用writeObject 插入数据

反序列化：

从字节流创建Java对象的相反过程，使用 readObject 读取数据
### 写一个User类
```
public class _01_User implements Serializable {

  private String name;
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  private void readObject(java.io.ObjectInputStream in) throws IOException {
    System.out.println("readObject..");
    //反序列化过程中，弹计算器
    Runtime.getRuntime().exec("/system/Applications/Calculator.app/Contents/MacOS/Calculator");
  }

  private void writeObject(java.io.ObjectOutputStream on) throws IOException {
    System.out.println("writeObject");
    
  }
}

```

### 序列化
```
public class _02_Serailized implements Serializable {

  public static void main(String[] args) throws IOException {
    _01_User user = new _01_User();
    FileOutputStream fos =new FileOutputStream("output.ser");
    ObjectOutputStream oos =new ObjectOutputStream(fos);
    oos.writeObject(user);
    oos.close();
  }
}

```
### 反序列化
```
public class _03_Deserialize {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream("output.ser");
    ObjectInputStream ois = new ObjectInputStream(fis);
    ois.readObject();
    ois.close();
  }
}

```
result:
```
mac系统弹出计算器
```