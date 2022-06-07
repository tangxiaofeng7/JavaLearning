package com.txf.Reflection;

import java.util.Arrays;
import java.util.List;

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
