package model;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DetailDb {
  DataSource dataSource;
    public DetailDb() throws NamingException{
    try{
    Context ctx =new InitialContext();
    dataSource =(DataSource) ctx.lookup("jdbc/addressbook");
    
    
    }
    catch(NamingException e){
    e.printStackTrace();
    }
    
    }

    public void createUser(String ID){
      try {
          Connection connection=dataSource.getConnection();
          String query="INSERT INTO ACCOUNTS VALUES(?,?,?,?,?)";
          
      } 
      catch (SQLException ex)
      {
          Logger.getLogger(DetailDb.class.getName()).log(Level.SEVERE, null, ex);
      }
    
    
    }
    
}
