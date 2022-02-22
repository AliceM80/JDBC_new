package main.java;

import java.sql.*;


public class exercise1 {

  public static void main(String[] args) {


    String url = "jdbc:postgresql://localhost:5432/java_heroes?";
    String user = "temporaryadmin";
    String password = "";

    //"try with resources", connection will closed automatically
    try (Connection conn = DriverManager.getConnection(url, user, password)) {
      System.out.println("Connection with database is successful");

    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }

  }
}


//***Hint:***
//- Download JDBC Driver library for PostgreqSQL
//-- Search on internet for the above.
//- Add this to the classpath
//- Create an instance of *Connection* using *DriverManager* API
//-- Specify the URL (with default database), username and password appropriately
//- Lookup into "pg_database" table for the "datname" field.
//- Iterate through the result and gather the result/values
//- Display the gathered values as the list of databases
