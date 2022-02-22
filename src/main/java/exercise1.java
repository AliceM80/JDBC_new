package main.java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class exercise1 {

  public static void main(String[] args) {


    String url = "jdbc:postgresql://localhost:5432/java_heroes?";
    String user = "temporaryadmin";
    String password = "";


    //"try with resources", connection will closed automatically
    try (Connection conn = DriverManager.getConnection(url, user, password)) {

      String query = "SELECT datname FROM pg_database";
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      List<String> datNames = new ArrayList<>();

      while (rs.next()){
        datNames.add(rs.getString("datname"));
      }

      System.out.println(datNames);


    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }

  }
}

//Should be working as well
  /*Connection conn = DriverManager.getConnection(url, user, password);
  DatabaseMetaData metadata = conn.getMetaData();
  ResultSet rs = metadata.getCatalogs();

    while (rs.next()) {

            String aDBName = rs.getString(1);
            System.out.println(aDBName);
            }

            conn.close();

            }

            }*/

//***Hint:***
//- Download JDBC Driver library for PostgreqSQL
//-- Search on internet for the above.
//- Add this to the classpath
//- Create an instance of *Connection* using *DriverManager* API
//-- Specify the URL (with default database), username and password appropriately
//- Lookup into "pg_database" table for the "datname" field.
//- Iterate through the result and gather the result/values
//- Display the gathered values as the list of databases
