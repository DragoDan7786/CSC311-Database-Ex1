/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testaccess;

import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author soblab
 */
public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        String databaseURL = "";
        Connection conn = null;
        System.out.println("Connection Successful");
        try {
            databaseURL = "jdbc:ucanaccess://.//Persons.accdb";
            //allows access to database
            conn = DriverManager.getConnection(databaseURL);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String tableName = "Persons";
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select * from " + tableName);
            while (result.next()) {
                int id = result.getInt("ID");
                String first = result.getString("First");
                String last = result.getString("Last");
                int age = result.getInt("Age");
                System.out.printf("%d %s %s %d\n", id, first, last, age);
            }
        } catch (SQLException except) {
            except.printStackTrace();
        }

    }
}
