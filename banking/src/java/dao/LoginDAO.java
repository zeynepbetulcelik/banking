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
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
/**
 *
 * @author zeynep
 */



import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

public class LoginDAO {

    /**
     *
     * @param user
     * @param password
     * @return
     */

    DataSource dataSource;
    public LoginDAO() throws NamingException{
    try{
    Context ctx =new InitialContext();
    dataSource =(DataSource) ctx.lookup("jdbc/addressbook");
    
    
    }
    catch(NamingException e){
    e.printStackTrace();
    }
    
    }
    public boolean kontrol_kullanici(String username, String password) throws SQLException{
if ( dataSource == null )
 throw new SQLException( "Unable to obtain DataSource" );

 // obtain a connection from the connection pool
 Connection connection = dataSource.getConnection();

 // check whether connection was successful
 if ( connection == null )
 throw new SQLException( "Unable to connect to DataSource" );

 try
 {
       Statement st = connection.createStatement();
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
