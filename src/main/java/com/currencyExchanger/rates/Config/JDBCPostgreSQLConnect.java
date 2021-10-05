package com.currencyExchanger.rates.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCPostgreSQLConnect {

   public static Connection connection() {
      Connection connection = null;
      try {
         Class.forName("org.postgresql.Driver");
      } catch (ClassNotFoundException e){
         System.out.println("Not found SQL Driver");
         e.printStackTrace();
      }
      try {
         connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/RatesDB", "postgres", "aezakmi52");
         System.out.println("Connection successful !");
         return connection;
      } catch (SQLException e){
         System.out.println(e.getMessage());
      }
      return connection;
   }
}
