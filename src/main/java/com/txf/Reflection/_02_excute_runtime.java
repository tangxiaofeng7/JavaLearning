package com.txf.Reflection;

/**
 * 反射执行命令
 */
public class _02_excute_runtime {

  public static void main(String[] args) throws Exception {
    /*
    Class clazz = Class.forName("java.lang.Runtime");
    Method execMethod = clazz.getMethod("exec", String.class);
    Method getRuntimeMethod = clazz.getMethod("getRuntime");
    Object runtime = getRuntimeMethod.invoke(clazz);
    execMethod.invoke(runtime, "open -a Calculator.app");
    */
    Class clazz = Class.forName("java.lang.Runtime");
    clazz.getMethod("exec", String.class)
        .invoke(clazz.getMethod("getRuntime").invoke(clazz), "open -a Calculator.app");
  }
}
