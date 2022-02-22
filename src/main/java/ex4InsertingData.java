package main.java;

import java.sql.*;

public class ex4InsertingData {

  public static void main(String[] args){

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

      String sql = "INSERT INTO employees " +
              "VALUES ('Adam','Falon','adam.falon@dci.com'),('Mary','Gold','mary.gold@dci.com'),('Adam','Currie','adam.currie@dci.com')," +
              "('Bryan','Jhonson','bryan.Jhonson@dci.com'),('Prasad','Ritesh','prasad.ritesh@dci.com'),('Mary','Jhonson','mary.jhonson@dci.com')";
     stmt.executeUpdate(sql);


      System.out.println("Inserted records into the table.");


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