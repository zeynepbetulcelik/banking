/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author omerc
 */
public class NewAccountDb {
    DataSource dataSource;
    public NewAccountDb() throws NamingException{
        try{
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/addressbook");
        }
        catch(NamingException e){
            e.printStackTrace();
        }
    }


        public boolean NewAccount(String user_id, String account_name, String account_type) throws SQLException{
            boolean flag=true;
             model.LoginDb logindb;
             
            String account_id =util.Utils.generateUUID();
Connection connection = dataSource.getConnection();
if(connection==null)
throw new SQLException("Unable to connect to DataSource");
try{
    String query="INSERT INTO ACCOUNTS VALUES(?,?,?,?,?)";
PreparedStatement pstmt = connection.prepareStatement(query);
Statement st = connection.createStatement();

        pstmt.setString(1, account_id);
        pstmt.setString(2, user_id);
        pstmt.setString(3,account_type);
        pstmt.setDouble(4,0);
        pstmt.setString(5,account_name);
        
        st= connection.createStatement();
        pstmt.executeUpdate();
        flag=true;
}catch(SQLException s){
   JOptionPane.showMessageDialog(null, "Hata: " + s.toString());
           flag=false;
}
return  flag;

}

}
