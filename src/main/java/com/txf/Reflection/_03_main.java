package com.txf.Reflection;

public class _03_main {

  public static void main(String[] args) throws Exception {
    _03_EvilExcute excute = new _03_EvilExcute();
    //修改本地的恶意类
    excute.ref("com.txf.Reflection._03_EvilClass");
  }
}
