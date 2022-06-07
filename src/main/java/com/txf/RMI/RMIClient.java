package com.txf.RMI;

import java.rmi.Naming;

public class RMIClient {
  public static void main(String[] args) throws Exception {
    RMIServer.IRemoteHelloWorld hello = (RMIServer.IRemoteHelloWorld) Naming.lookup("rmi://127.0.0.1:1099/Hello");
    String ret = hello.hello("1");
    System.out.println( ret);
  }
}