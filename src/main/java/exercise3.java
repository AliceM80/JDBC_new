package main.java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;


public class exercise3 {


  public static void main(String[] args) throws Exception {

    DatabaseMetaData md = conn.getMetaData();
    ResultSet rs = md.getTables(null, null, "%", null);
    while (rs.next()) {
      if (rs.getString(4).equalsIgnoreCase("TABLE")) {
        System.out.println(rs.getString(3));
        //ColumnINDEX 3 is the TABLE_NAME (see documentation of DatabaseMetaData::getTables)
      }
    }
  }

    static Connection conn;
    static Statement st;

    static {
      try {

        // Establish the connection to the database.
        String url = "jdbc:postgresql://localhost:5432/java_heroes?";
        String user = "temporaryadmin";
        String password = "";

        conn = DriverManager.getConnection(url, user, password);


        st = conn.createStatement();
      } catch (Exception e) {
        System.err.println("Got an exception! ");
        e.printStackTrace();
        System.exit(0);
      }
    }
  }


//***Hint:***
//- Download JDBC Driver library for PostgreqSQL
//-- Search on internet for the above.
//- Add this to the classpath
//- Create an instance of *Connection* using *DriverManager* API
//-- Specify the URL with specified database, username and password appropriately
//- Get hold of *DatabaseMetaData* from the *Connection* object
//- Use *getTables* method on above to find the list of tables
//-- Note: Filter out everything which is not a table, technically
//- Display the gathered values as the list of Tables

