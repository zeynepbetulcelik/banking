/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Db;
import util.Utils;

/**
 *
 * @author zeynep
 */
public class PersonDb {

     public Person login(Person person) throws ClassNotFoundException, SQLException {

          Connection con = Db.getInstance().getConnection();

          String sql = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";

          try {
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, person.getUsername());
               ps.setString(2, person.getPassword());
               ResultSet rs = ps.executeQuery();
               while (rs.next()) {
                    person.setId(rs.getString("ID"));
                    person.setUsername(rs.getString("USERNAME"));
                    person.setEmail(rs.getString("EMAIL"));
                    person.setPassword(rs.getString("PASSWORD"));

               }
          } catch (SQLException e) {
               System.out.println(e.getMessage());
          }
          return person;
     }

     public boolean register(Person person) throws ClassNotFoundException {
          Connection con = Db.getInstance().getConnection();
          boolean status = false;
         
          Utils util = new Utils();
          person.setId(util.generateUUID());

          String sql = "INSERT INTO USERS VALUES(?,?,?,?,?,?)";

          try {
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, person.getUsername());
               ps.setString(2, person.getPassword());
               ps.setString(3, person.getPhonenumber());
               ps.setString(4, person.getEmail());
               ps.setString(5, person.getGender());
               ps.setString(6, person.getId());
               ps.executeUpdate();
               status=true;

          } catch (SQLException e) {
               System.out.println(e.getMessage());
               status=false;
          }
         
          return status;
     }
}
