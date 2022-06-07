package com.txf.classloader.ClassLoader;

import java.lang.reflect.Method;

/**
 * 自定义类加载（显式类加载）
 */
public class _04_ClassLoader extends ClassLoader{
  private static String testClassName = "";

  private static byte[] testClassBytes = new byte[]{
      -54, -2, -70, -66, 0, 0, 0, 52, 0, 17, 10, 0, 4, 0, 13, 8, 0, 14, 7, 0, 15, 7, 0, 16, 1, 0, 6, 60, 105, 110, 105, 116, 62, 1, 0, 3, 40, 41, 86, 1, 0, 4, 67, 111, 100, 101, 1, 0, 15, 76, 105, 110, 101, 78, 117, 109, 98, 101, 114, 84, 97, 98, 108, 101, 1, 0, 5, 70, 105, 114, 115, 116, 1, 0, 20, 40, 41, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 1, 0, 10, 83, 111, 117, 114, 99, 101, 70, 105, 108, 101, 1, 0, 19, 95, 48, 49, 95, 70, 105, 114, 115, 116, 67, 108, 97, 115, 115, 46, 106, 97, 118, 97, 12, 0, 5, 0, 6, 1, 0, 5, 102, 105, 114, 115, 116, 1, 0, 46, 99, 111, 109, 47, 116, 120, 102, 47, 99, 108, 97, 115, 115, 108, 111, 97, 100, 101, 114, 47, 67, 108, 97, 115, 115, 76, 111, 97, 100, 101, 114, 47, 95, 48, 49, 95, 70, 105, 114, 115, 116, 67, 108, 97, 115, 115, 1, 0, 16, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 0, 33, 0, 3, 0, 4, 0, 0, 0, 0, 0, 2, 0, 1, 0, 5, 0, 6, 0, 1, 0, 7, 0, 0, 0, 29, 0, 1, 0, 1, 0, 0, 0, 5, 42, -73, 0, 1, -79, 0, 0, 0, 1, 0, 8, 0, 0, 0, 6, 0, 1, 0, 0, 0, 5, 0, 1, 0, 9, 0, 10, 0, 1, 0, 7, 0, 0, 0, 27, 0, 1, 0, 1, 0, 0, 0, 3, 18, 2, -80, 0, 0, 0, 1, 0, 8, 0, 0, 0, 6, 0, 1, 0, 0, 0, 7, 0, 1, 0, 11, 0, 0, 0, 2, 0, 12
};

  @Override
  public Class<?> findClass(String name) throws ClassNotFoundException {
      return defineClass(testClassBytes, 0, testClassBytes.length);
  }

  public static void main(String[] args) {

    _04_ClassLoader loader = new _04_ClassLoader();

    try {
      // 使用自定义的类加载器加载类,基于双亲委派原则，因为前面testClassName是空或者可以理解为不存在，所以会用到前面重写的findClass来加载testClassBytes
      Class testClass = loader.loadClass(testClassName);

      // 反射创建类
      Object testInstance = testClass.newInstance();

      // 反射获取方法
      Method method = testInstance.getClass().getMethod("First");

      // 反射调用方法
      String str = (String) method.invoke(testInstance);

      System.out.println(str);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}