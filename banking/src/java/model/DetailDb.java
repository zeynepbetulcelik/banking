package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;

@ManagedBean(name="detail")
public class DetailDb {

     DataSource dataSource;

     public DetailDb() throws NamingException {
          try {
               Context ctx = new InitialContext();
               dataSource = (DataSource) ctx.lookup("jdbc/addressbook");

          } catch (NamingException e) {
               e.printStackTrace();
          }

     }

     public void createUser(String ID) {
          try {
               Connection connection = dataSource.getConnection();
               String query = "INSERT INTO ACCOUNTS VALUES(?,?,?,?,?)";

          } catch (SQLException ex) {
               Logger.getLogger(DetailDb.class.getName()).log(Level.SEVERE, null, ex);
          }

     }

     public ResultSet getBalancebyID(String ID) throws SQLException {
          Connection connection = dataSource.getConnection();
          if (connection == null) {
               throw new SQLException("Unable to connect to DataSource");
          }

          try {
               PreparedStatement object1 = connection.prepareStatement(
   "select * " +"from ACCOUNTS " +"where ACCOUNTS.ACCOUNT_USER_ID= '"+ID+"'");
        CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
     resultSet1.populate( object1.executeQuery() );
     return resultSet1;
                
          } catch (SQLException s) {
               JOptionPane.showMessageDialog(null, "Hata: " + s.toString());
               return null;
          }

     }

}


