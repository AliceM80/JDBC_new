package main.java;

import java.sql.*;


public class exercise4 {

  public static void main(String[] args) {


    String url = "jdbc:postgresql://localhost:5432/java_heroes?";
    String user = "temporaryadmin";
    String password = "";

    //"try with resources", connection will closed automatically
    try (Connection conn = DriverManager.getConnection(url, user, password)) {



      //print out table employee
      String query = "SELECT e.emp_id, e.fname, e.lname, e.age, e.address FROM stuff.employee e ORDER BY e.emp_id ASC";
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);


      //for printing out the column names
      int columns = rs.getMetaData().getColumnCount();
      for (int i = 1; i <= columns; i++)
        System.out.print(String.format("%-15s", rs.getMetaData().getColumnLabel(i)));

      System.out.println();

      while (rs.next()) {
        for (int i = 1; i <= columns; i++)
          System.out.print(String.format("%-15s", rs.getString(i)));
        System.out.println();
      }

      rs.close();
      stmt.close();


    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }

  }
}
