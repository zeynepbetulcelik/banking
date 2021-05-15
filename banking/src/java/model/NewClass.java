/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author zeynep
 */
public class NewClass {
     
     
     public static void main(String args[]) throws NamingException, SQLException{
     
     DetailDb db =new DetailDb();
     
     System.out.print(db.getBalancebyID("c4d8sc5sd4adf8s5-sd5sdf-5"));
     
     }
     
}

