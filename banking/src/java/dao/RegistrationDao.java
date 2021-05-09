/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author zeynep
 */

public class RegistrationDao {
    
    Connection conn;
	   public void Dbaglanti() throws SQLException {
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/banking", "zeynep", "zeynep");

    }
    
    public boolean register(String username,String password){
        boolean flag=true;
        try {
           Dbaglanti();
            String sorgu = "INSERT INTO KULLANICI VALUES  (?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sorgu);
            Statement st = conn.createStatement();
            pstmt.setString(1, username);
            pstmt.setString(2, password);
           st = conn.createStatement();
            pstmt.executeUpdate();
            flag=true;
            
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "Hata: " + s.toString());
            flag=false;
        }
      return flag;
    }
}
