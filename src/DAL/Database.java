package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Database access layer
public class Database {
  public static final String HOST = "10.14.0.10";
  public static final String DB = "project";
  public static final String USER = "dev";
  public static final String PASS = "ProjectDev#2020";

  public static Connection connect(String host, String user, String pass, String db) {
    Connection conn = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://" + host + ":3306/" + db;
      conn = DriverManager.getConnection(url, user, pass);
    } catch (ClassNotFoundException ex) {

      System.out.println("Could Not Load MySQL Driver");
    } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Could Not Connect to MySQL Server");
    }

    return conn;
  }

}