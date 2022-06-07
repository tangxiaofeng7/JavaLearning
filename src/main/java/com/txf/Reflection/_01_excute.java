package com.txf.Reflection;

import java.io.*;
import org.javaweb.utils.IOUtils;

/**
 * 普通执行命令
 */
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
