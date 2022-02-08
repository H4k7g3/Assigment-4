package com.company;

import com.company.controllers.MedController;
import com.company.data.DB;
import com.company.data.interfaces.IDB;
import com.company.repositories.MedRepository;
import com.company.repositories.interfaces.IMedRepository;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
          String connectionUrl = "jdbc:postgresql://localhost:5432/medicine";
          Connection con = null;
          ResultSet rs = null;
          Statement stmt = null;
          try {
    //             Here we load the driver’s class file into memory at the runtime
              Class.forName("org.postgresql.Driver");

                // Establish the connection
              con = DriverManager.getConnection(connectionUrl, "postgres", "212177");

   //              The object of statement is responsible to execute queries with the database
              stmt = con.createStatement();

                 //The executeQuery() method of Statement interface is used to execute queries
                 //to the database. This method returns the object of ResultSet that can be
                //used to get all the records of a table that matches the sql statement
              rs = stmt.executeQuery("SELECT * FROM meddata");

              while (rs.next())  //  Processing the result
                  System.out.println(rs.getInt("id") + "  "
                          + rs.getString("name") + "  " + rs.getInt("price")+"  "
                          + rs.getString("expiration") +"  "
                          + rs.getString("manufacturer")+"  "
                          + rs.getString("byrecept"));
          }
          catch (Exception e) {
              System.out.println("Exception occurred!");
          } finally {

              try {    //Close connection - clean up the system resources
                  con.close();
              } catch (Exception e) {
                  System.out.println("Exception occurred!");
              }
          }

          System.out.println("Finished!");
        IDB db = new DB();
        IMedRepository repo = new MedRepository(db);
        MedController controller = new MedController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}