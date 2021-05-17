/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.net.www.protocol.http.HttpURLConnection;

/**
 *
 * @author zeynep
 */
public class Db {

     private static Db instance = null;
     private static Connection connection = null;

     private Db() {

     }

     public static Db getInstance() {
          if (instance == null) {
               instance = new Db();
               openConection();
          }
          return instance;
     }

     private static void openConection() {
          if (connection == null) {
               try {
                    connection = DriverManager.getConnection("jdbc:derby://localhost:1527/addressbook", "APP", "APP");
               } catch (SQLException ex) {
                    Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
               }
          }
     }

     public Connection getConnection() {
          return connection;
     }

}
