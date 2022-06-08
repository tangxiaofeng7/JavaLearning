package com.txf.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    //定义数据库
    String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    String USERNAME = "root";
    String PASSWORD = "";

    //这里可以省略Class.forName(driver);

    //建立连接
    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

    //执行sql
    String sql = "select version()";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    //输出结果
    while (rs.next()) {
      System.out.println(rs.getString("version()"));
    }
  }
}
