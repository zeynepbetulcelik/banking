package model;

import entity.Account;
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
                  "select *  "
                  + "from ACCOUNTS "
                  + "where ACCOUNTS.ACCOUNT_USER_ID='" + Person.PersonInstance.getId() + "'"
          );
          CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
          resultSet1.populate(object1.executeQuery());
          return resultSet1;

     }
     public void transferBalance(String gonderen,String alan,double miktar) throws SQLException{
         double firstaccountbalance = 0;
           double result = 0;
           Connection con = Db.getInstance().getConnection();
           Statement st = con.createStatement();
           String sql1="SELECT ACCOUNT_BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID= '" + gonderen + "' ";
           ResultSet rs = st.executeQuery(sql1);
           while(rs.next()){
           firstaccountbalance = rs.getDouble("ACCOUNT_BALANCE");
           result = firstaccountbalance - miktar;
           
           }
           Statement stm = con.createStatement();
          String sql = "UPDATE ACCOUNTS SET ACCOUNT_BALANCE ="+result+" WHERE ACCOUNT_ID='"+gonderen+"'    ";
          stm.executeUpdate(sql);
          Statement st2 = con.createStatement();
           String sql4="SELECT ACCOUNT_BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID= '" + alan+ "' ";
           ResultSet rs1 = st.executeQuery(sql4);
           while(rs1.next()){
           firstaccountbalance = rs1.getDouble("ACCOUNT_BALANCE");
           result = firstaccountbalance +miktar;
           
           }
           Statement stm6 = con.createStatement();
          String sq15 = "UPDATE ACCOUNTS SET ACCOUNT_BALANCE ="+result+" WHERE ACCOUNT_ID='"+alan+"'    ";
          stm.executeUpdate(sq15);
     }

     public ResultSet getCreditCards() throws SQLException {
          Connection con = Db.getInstance().getConnection();
          String sql = "select *  from CREDIT_CARDS INNER JOIN USERS ON USERS.ID = CREDIT_CARDS.USER_ID where CREDIT_CARDS.USER_ID = '" + Person.PersonInstance.getId() + "'";
          PreparedStatement object1 = con.prepareStatement(sql);
          CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
          resultSet1.populate(object1.executeQuery());
          return resultSet1;

     }

     public ResultSet getDebitCards() throws SQLException {
          Connection con = Db.getInstance().getConnection();
          String sql = "select *  from DEBIT_CARDS INNER JOIN USERS ON USERS.ID = DEBIT_CARDS.USER_ID where DEBIT_CARDS.USER_ID = '" + Person.PersonInstance.getId() + "'";
          PreparedStatement object1 = con.prepareStatement(sql);
          CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
          resultSet1.populate(object1.executeQuery());
          return resultSet1;

     }

     public boolean registAccount(String account_name, String account_type) {
          Connection con = Db.getInstance().getConnection();
          boolean status = false;
          int count = 0;

          Utils util = new Utils();

          String sql = "INSERT INTO ACCOUNTS VALUES(?,?,?,?,?)";
          try {
               PreparedStatement ps = con.prepareStatement(sql);
               ps.setString(1, util.generateUUID());
               ps.setString(2, Person.PersonInstance.getId());
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
          String sql = "select BILLS.TYPE, BILLS.QUANTITY  from BILLS where BILLS.USER_ID = '" + Person.PersonInstance.getId() + "'";
          PreparedStatement object1 = con.prepareStatement(sql);
          CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
          resultSet1.populate(object1.executeQuery());
          return resultSet1;

     }

     public ResultSet getBillAmountByID(String type) throws SQLException {
          Connection con = Db.getInstance().getConnection();
          double sum = 10;
          String sql = "SELECT SUM(QUANTITY) as SUMQUANTITY FROM BILLS WHERE USER_ID = '" + Person.PersonInstance.getId() + "' and TYPE = '" + type + "'";
          PreparedStatement object1 = con.prepareStatement(sql);
          CachedRowSet resultSet = new com.sun.rowset.CachedRowSetImpl();
          resultSet.populate(object1.executeQuery());

          return resultSet;

     }

     public ResultSet billandbalance(String type) throws SQLException {
          Connection con = Db.getInstance().getConnection();

          String sql = "SELECT * FROM BILLS INNER JOIN  USERS ON USERS.ID=BILLS.USER_ID WHERE USER_ID = '" + Person.PersonInstance.getId() + "' and TYPE = '" + type + "'";
          PreparedStatement object1 = con.prepareStatement(sql);
          CachedRowSet rs = new com.sun.rowset.CachedRowSetImpl();
          rs.populate(object1.executeQuery());
          return rs;
     }

     public void payBill(String type, Double miktar, String account_id) throws SQLException {
           double firstaccountbalance = 0;
           double result = 0;
           Connection con = Db.getInstance().getConnection();
           Statement st = con.createStatement();
           String sql1="SELECT ACCOUNT_BALANCE FROM ACCOUNTS WHERE ACCOUNT_ID= '" + account_id + "' ";
           ResultSet rs = st.executeQuery(sql1);
           while(rs.next()){
           firstaccountbalance = rs.getDouble("ACCOUNT_BALANCE");
           result = firstaccountbalance - miktar;
           
           }
           Statement stm = con.createStatement();
          String sql = "UPDATE ACCOUNTS SET ACCOUNT_BALANCE ="+result+" WHERE ACCOUNT_ID='"+account_id+"'    ";
          stm.executeUpdate(sql);
           
           
           Statement stmt = con.createStatement();
           String sql2 = "DELETE FROM BILLS WHERE BILLS.USER_ID = '" + Person.PersonInstance.getId() + "' and BILLS.TYPE = '" + type + "'AND BILLS.QUANTITY=" + miktar + "";
           stmt.executeUpdate(sql2);
           
           
     }

     public boolean deleteAccount(String account_id) throws SQLException {
          Connection con = Db.getInstance().getConnection();

          boolean flag = false;

          try {
               Statement stmt = con.createStatement();
               String sql = "DELETE FROM ACCOUNTS WHERE ACCOUNTS.ACCOUNT_ID = '" + account_id + "' ";
               stmt.executeUpdate(sql);
               flag = true;
          } catch (SQLException ex) {
               flag = false;
               ex.printStackTrace();
          }

          return flag;
     }

     public ResultSet getUserInfo() throws SQLException {
          Connection con = Db.getInstance().getConnection();
          String sql = "SELECT * FROM USERS WHERE ID='" + Person.PersonInstance.getId() + "'";
          PreparedStatement object1 = con.prepareStatement(sql);
          CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
          resultSet1.populate(object1.executeQuery());
          return resultSet1;

     }

     public ResultSet getaccountandusers() throws SQLException {
          Connection con = Db.getInstance().getConnection();
          String sql = "SELECT * FROM ACCOUNTS INNER JOIN USERS ON ACCOUNTS.ACCOUNT_USER_ID=USERS.ID WHERE ID='" + Person.PersonInstance.getId() + "'";
          PreparedStatement object1 = con.prepareStatement(sql);
          CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
          resultSet1.populate(object1.executeQuery());
          return resultSet1;
     }

     public double calculator() throws SQLException {
          Connection con = Db.getInstance().getConnection();

          double balanceson = 0;

          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("SELECT ACCOUNT_BALANCE FROM ACCOUNTS WHERE ACCOUNTS.ACCOUNT_USER_ID = '" + Person.PersonInstance.getId() + "'");

          while (rs.next()) {
               balanceson += rs.getDouble("ACCOUNT_BALANCE");

          }

          return balanceson;

     }
     
     
     public void updatetotalbalance() throws SQLException{
     double balance=calculator();
       Connection con = Db.getInstance().getConnection();
       Statement stmt=con.createStatement();
     
       String sql="UPDATE USERS SET TOTALBALANCE ="+balance+"  WHERE ID='"+Person.PersonInstance.getId()+"'";
       stmt.executeUpdate(sql);
        

     }
     
     public void updateBills(double miktar) throws SQLException{
         double totalbalance = 0;
         double result = 0;
         Connection con = Db.getInstance().getConnection();
         Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("SELECT TOTALBALANCE FROM USERS WHERE ID = '" + Person.PersonInstance.getId() + "'");
          while(rs.next()){
                totalbalance = rs.getDouble("TOTALBALANCE");
                result = totalbalance - miktar;
          }
          
          Statement stmt = con.createStatement();
          String sql = "UPDATE USERS SET TOTALBALANCE ="+result+" WHERE ID='"+Person.PersonInstance.getId()+"'    ";
          stmt.executeUpdate(sql);
     }
     
     
}
