package Interface.Window.DB_function;

import Interface.Window.Conecting_Window;

import java.sql.*;

public class DB_Checker extends Conecting_Window {


   public void createDatabase(String db_name)
   {
       String url = "jdbc:sqlite:D:/sqlite/db/" + db_name;

       try (Connection conn = DriverManager.getConnection(url)) {
           if (conn != null) {
               DatabaseMetaData meta = conn.getMetaData();
               System.out.println("The driver name is " + meta.getDriverName());
               System.out.println("A new database has been created.");
           }

       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
   }

   public Connection connectionDatabase(String db_name) {
       Connection connection = null;
       try {
           Class.forName("org.sqlite.JDBC");
           connection = DriverManager.getConnection("jdbc:sqlite:" + db_name + ".db");
       } catch (Exception e) {
           e.printStackTrace();
       }
       return connection;
   }



}

