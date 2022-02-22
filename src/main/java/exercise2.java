package main.java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class exercise2 {

  public static void main(String[] args) throws SQLException {

  String url = "jdbc:postgresql://localhost:5432/java_heroes";
  String user = "temporaryadmin";
  String password = "";


      //"try with resources", connection will closed automatically
      try (Connection conn = DriverManager.getConnection(url, user, password)) {

        String query = "SELECT schema_name FROM information_schema.schemata ORDER BY schema_name ASC";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<String> schemaNames = new ArrayList<>();

        while (rs.next()){
          schemaNames.add(rs.getString("schema_name"));
        }

        System.out.println(schemaNames);


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
//-- Specify the URL with specified database, username and password appropriately
//- Lookup into "information_schema.schemata" view for the "schema_name" field.
//- Iterate through the result and gather the result/values
//- Display the gathered values as the list of schemas
