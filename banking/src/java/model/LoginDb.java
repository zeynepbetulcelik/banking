/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.sql.DataSource;
/**
 *
 * @author zeynep
 */




public class LoginDb {

    /**
     *
     * @param user
     * @param password
     * @return
     */
    DataSource dataSource;

    public LoginDb() throws NamingException {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/addressbook");

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    public ResultSet kontrol_kullanici(String username, String password) throws SQLException {

        Connection connection = dataSource.getConnection();
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        }

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM USERS WHERE USERNAME = '" + username + "'");
            if (rs.next()) {
                return rs;
            }
            return null;
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "Hata: " + s.toString());
            return null;
        }
    }
    
  

    public String getID(String username) throws SQLException {
        String id = "";
        Connection connection = dataSource.getConnection();
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT ID FROM USERS WHERE USERNAME = '" + username + "'");
            if (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "Hata: " + s.toString());
        }
        return id;
    }

    public boolean get_id_byusername(String username, String id) throws SQLException {
        Connection connection = dataSource.getConnection();
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT ID FROM USERS WHERE USERNAME = '" + username + "'");
            if (rs.next()) {
                id = rs.getString(1);
                return true;
            }
        } catch (SQLException s) {
            JOptionPane.showMessageDialog(null, "Hata: " + s.toString());
        }
        return false;
    }

}
