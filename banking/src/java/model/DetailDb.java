package model;

import entity.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
      
      String sql ="SELECT* FROM BILLS INNER JOIN  USERS ON USERS.ID=BILLS.USER_ID WHERE USER_ID = '"+Person.PersonInstance.getId()+"' and TYPE = '"+ type+"'";
      PreparedStatement object1 = con.prepareStatement(sql);
          CachedRowSet rs = new com.sun.rowset.CachedRowSetImpl();
          rs.populate(object1.executeQuery());
     return rs;
     }    

}
