/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author zeynep
 */





public class LoginDAO {

    /**
     *
     * @param user
     * @param password
     * @return
     */
  Connection conn;
	   public void Dbaglanti() throws SQLException {
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/banking", "zeynep", "zeynep");

    }
   public boolean kontrol_kullanici(String username, String password) {

        try {
           Dbaglanti();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT PASSWORD FROM USERS WHERE USERNAME = '" + username + "'");
            if (rs.next()) {
                return password.equals(rs.getString(1));
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "Hata: " + s.toString());
        }
        return false;
    }

    
}
