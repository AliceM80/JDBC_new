package main.java;

import java.sql.*;

public class ex4PrintOut {


    public static void main(String[] args){

      String url = "jdbc:postgresql://localhost:5432/dci";
      String user = "temporaryadmin";
      String password = "";

      //"try with resources", connection will closed automatically
      try (Connection conn = DriverManager.getConnection(url, user,password)){


        //print out table employees (db dci)
        String query = "SELECT * FROM employees e ORDER BY e.fname ASC";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        //for printing out the column names
        int columns = rs.getMetaData().getColumnCount();
        for(int i = 1; i <= columns; i++)
          System.out.print(String.format("%-25s", rs.getMetaData().getColumnLabel(i)));

        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------");

        while(rs.next()){
          for(int i = 1; i <= columns; i++)
            System.out.print(String.format("%-25s", rs.getString(i)));
          System.out.println();
        }

        rs.close();
        stmt.close();


      }catch (SQLException ex){
        System.err.println(ex.getMessage());
      }


    }
  }
