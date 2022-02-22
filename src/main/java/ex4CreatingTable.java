package main.java;

import java.sql.*;


public class ex4CreatingTable {


  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;

    String url = "jdbc:postgresql://localhost:5432/dci";
    String user = "temporaryadmin";
    String password = "";

    //get connection to the database
    try {
      conn = DriverManager.getConnection(url, user, password);
      //executing the query
      stmt = conn.createStatement();

      String sql = "CREATE TABLE employees" +
              "(fname VARCHAR(30) NOT NULL," +
              "lname VARCHAR(30) NOT NULL," +
              "email VARCHAR(50) UNIQUE NOT NULL," +
              "contact int)";
      stmt.executeUpdate(sql);
      System.out.println("Table is created");

    } catch (SQLException se) {
      //handle errors for JDBC
      se.printStackTrace();
    } catch (Exception e) {
      //handle errors for class for name
      e.printStackTrace();
    } finally {
      //finally block basically is used to close the resources
      try {
        if (stmt != null)
          conn.close();
      } catch (SQLException se) {
      }//do nothing
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        se.printStackTrace();
      }//end of finally try
    }//end try
  }//end main

      }

