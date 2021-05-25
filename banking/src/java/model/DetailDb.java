package model;

import entity.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.sql.rowset.CachedRowSet;
import util.Db;
import util.Utils;

@ManagedBean(name = "detail")
public class DetailDb {

     public ResultSet getAccounts() throws SQLException {
          Connection con = Db.getInstance().getConnection();
          PreparedStatement object1 = con.prepareStatement(
                  "select ACCOUNTS.ACCOUNT_NAME, ACCOUNTS.ACCOUNT_TYPE, ACCOUNTS.ACCOUNT_BALANCE  "
                  + "from ACCOUNTS "
                  + "where ACCOUNTS.ACCOUNT_USER_ID='" + Person.PersonInstance.getId() + "'"
          );
          CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
          resultSet1.populate(object1.executeQuery());
          return resultSet1;

     }


     
     public ResultSet getCreditCards() throws SQLException {
          Connection con = Db.getInstance().getConnection();
          String sql= "select *  from CREDIT_CARDS INNER JOIN USERS ON USERS.ID = CREDIT_CARDS.USER_ID where CREDIT_CARDS.USER_ID = '" + Person.PersonInstance.getId() + "'";
          PreparedStatement object1 = con.prepareStatement(sql);
          CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
          resultSet1.populate(object1.executeQuery());
          return resultSet1;

     }
     
     public ResultSet getDebitCards() throws SQLException {
          Connection con = Db.getInstance().getConnection();
          String sql= "select *  from DEBIT_CARDS INNER JOIN USERS ON USERS.ID = DEBIT_CARDS.USER_ID where DEBIT_CARDS.USER_ID = '" + Person.PersonInstance.getId() + "'";
          PreparedStatement object1 = con.prepareStatement(sql);
          CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
          resultSet1.populate(object1.executeQuery());
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

     public ResultSet getbill() throws SQLException {
          Connection con = Db.getInstance().getConnection();
          String sql= "select BILLS.TYPE, BILLS.QUANTITY  from BILLS where BILLS.USER_ID = '" + Person.PersonInstance.getId() + "'";
          PreparedStatement object1 = con.prepareStatement(sql);
          CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
          resultSet1.populate(object1.executeQuery());
          return resultSet1;

     }
     public ResultSet getBillAmountByID(String type) throws SQLException{
           Connection con = Db.getInstance().getConnection();
           double sum=10;
          String sql="SELECT SUM(QUANTITY) as SUMQUANTITY FROM BILLS WHERE USER_ID = '"+Person.PersonInstance.getId()+"' and TYPE = '"+ type+"'";
           PreparedStatement object1 = con.prepareStatement(sql);
          CachedRowSet resultSet = new com.sun.rowset.CachedRowSetImpl();
          resultSet.populate(object1.executeQuery());
          
           
                    return resultSet;
          
     }
     public ResultSet billandbalance(String type) throws SQLException{
      Connection con = Db.getInstance().getConnection();
      
      String sql ="SELECT * FROM BILLS INNER JOIN  USERS ON USERS.ID=BILLS.USER_ID WHERE USER_ID = '"+Person.PersonInstance.getId()+"' and TYPE = '"+ type+"'";
      PreparedStatement object1 = con.prepareStatement(sql);
          CachedRowSet rs = new com.sun.rowset.CachedRowSetImpl();
          rs.populate(object1.executeQuery());
     return rs;
     }    
     
     public boolean payBill(String type, Double miktar) throws SQLException {
      Connection con = Db.getInstance().getConnection();
      
     
     
      boolean flag = false;
      
         try {
           Statement stmt=con.createStatement();
            String sql ="DELETE FROM BILLS WHERE BILLS.USER_ID = '"+Person.PersonInstance.getId()+"' and BILLS.TYPE = '"+ type+"'AND BILLS.QUANTITY="+miktar+"";
            stmt.executeUpdate(sql);
                 flag = true;
         } catch (SQLException ex) {
             flag=false;
              ex.printStackTrace();
         }
        
          
     return flag;
     } 
    /* public void updatetotalbalance(){
     }
*/
}
