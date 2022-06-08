package com.txf.Deserialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class _02_Serailized implements Serializable {

  public static void main(String[] args) throws IOException {
    _01_User user = new _01_User();
    FileOutputStream fos =new FileOutputStream("output.ser");
    ObjectOutputStream oos =new ObjectOutputStream(fos);
    oos.writeObject(user);
    oos.close();
  }
}
