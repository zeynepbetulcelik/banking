package model;

import entity.Account;
import entity.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.sql.rowset.CachedRowSet;


import util.Db;
import util.Utils;
@ManagedBean( name="detail" )
public class DetailDb {

     
public ResultSet getAccounts() throws SQLException {
          Connection con = Db.getInstance().getConnection();
        PreparedStatement object1 = con.prepareStatement(
 "select ACCOUNTS.ACCOUNT_NAME,USERS.USERNAME " +
"from ACCOUNTS, USERS " +
"where ACCOUNTS.ACCOUNT_USER_ID=USERS.ID " 
);
 CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
  resultSet1.populate( object1.executeQuery() );
  return resultSet1;

         
     
     }

     public boolean registAccount(String account_name, String account_type, String id) {
          Connection con = Db.getInstance().getConnection();
          boolean status = false;
          int count = 0;

          Utils util = new Utils();

          String sql = "INSERT INTO ACCOUNTS VALUES(?,?,?,?,?)";
          try {
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, util.generateUUID());
               ps.setString(2, id);
               ps.setString(3, account_type);
               ps.setDouble(4, 0);
               ps.setString(5, account_name);

               ps.executeUpdate();

          } catch (SQLException e) {
               System.out.println(e.getMessage());
          }
          if (count != 0) {
               status = true;
          }
          return status;
     }

}
