## 初见RMI
RMI（Remote Method Invocation），远程⽅法调⽤

RMI分为三个主体部分：

Client-客户端：客户端调用服务端的方法
Server-服务端：远程调用方法对象的提供者，也是代码真正执行的地方，执行结束会返回给客户端一个方法执行的结果。
Registry-注册中心：其实本质就是一个map，相当于是字典一样，用于客户端查询要调用的方法的引用。

> JDK 1.7
Java版本低于7u21、6u45，或者设置了 java.rmi.server.useCodebaseOnly=false

### RMI Server

```
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

```

### RMI Client
```
public class TrainMain {
  public static void main(String[] args) throws Exception {
    RMIServer.IRemoteHelloWorld hello = (RMIServer.IRemoteHelloWorld) Naming.lookup("rmi://127.0.0.1:1099/Hello");
    String ret = hello.hello("1");
    System.out.println( ret);
  }
}
```