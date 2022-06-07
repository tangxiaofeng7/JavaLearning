package com.txf.classloader.ClassLoader;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * class转byte数组
 */
public class _03_ClassToByte {

  public static void main(String[] args) throws Exception {
    byte[] b = inputStreamToBytes(new FileInputStream("/Users/txf/Ideaproject/JavaLearning/src/main/java/com/txf/classloader/ClassLoader/_01_FirstClass.class"));
    List<String> list = new ArrayList();
    for(int i = 0; i < b.length; ++i) {
      list.add(b[i] + "");
    }
    System.out.print(String.join(", ", list));
  }

  public static byte[] inputStreamToBytes(InputStream is) throws Exception {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buff = new byte[1024];
    int len;
    while((len = is.read(buff)) != -1) {
      baos.write(buff, 0, len);
    }
    baos.flush();
    is.close();
    return baos.toByteArray();
  }
}