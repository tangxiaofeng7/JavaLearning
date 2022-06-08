## 初识JDBC

• Java数据库连接<br>
• Java API，客户端访问数据库<br>


### JDBC实例
```
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

```
result:
```
8.0.29
```
