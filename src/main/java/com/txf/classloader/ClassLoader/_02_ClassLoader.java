package com.txf.classloader.ClassLoader;

/**
 * 调用类下的方法（隐式类加载）
 */
public class _02_ClassLoader{
  public static void main(String[] args) {
    _01_FirstClass a01FirstClass = new _01_FirstClass();
    System.out.println(a01FirstClass.first());
  }
}
