package com.txf.Reflection;


import java.lang.reflect.Constructor;

public class _05_excute_private {

  public static void main(String[] args) throws Exception {
    Class clazz = Class.forName("java.lang.Runtime");
    Constructor m = clazz.getDeclaredConstructor();
    m.setAccessible(true);
    clazz.getMethod("exec", String.class).invoke(m.newInstance(), "open -a Calculator.app");
  }
}
