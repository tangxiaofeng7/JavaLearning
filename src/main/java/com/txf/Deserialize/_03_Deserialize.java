package com.txf.Deserialize;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class _03_Deserialize {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream("output.ser");
    ObjectInputStream ois = new ObjectInputStream(fis);
    ois.readObject();
    ois.close();
  }
}
