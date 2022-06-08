package com.txf.Deserialize;

import java.io.IOException;
import java.io.Serializable;

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
