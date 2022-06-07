package com.txf.RMI;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {
  //远程接口
  public interface IRemoteHelloWorld extends Remote {
    public String hello(String a) throws RemoteException;
  }
  //远程接口的实现
  public class RemoteHelloWorld extends UnicastRemoteObject implements IRemoteHelloWorld{
    protected RemoteHelloWorld() throws RemoteException {
      super();
      System.out.println("构造函数中");
    }

    public String hello(String a) throws RemoteException {
      System.out.println("call from");
      return "Hello world";
    }
  }
  //注册远程对象
  private void start() throws Exception {
    //远程对象实例
    RemoteHelloWorld h = new RemoteHelloWorld();
    //创建注册中心
    LocateRegistry.createRegistry(1099);
    //绑定对象实例到注册中心
    Naming.rebind("//127.0.0.1/Hello", h);
  }
  //main函数
  public static void main(String[] args) throws Exception {

    new RMIServer().start();
  }
}
