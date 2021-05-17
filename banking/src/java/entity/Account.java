/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author zeynep
 */
public class Account {
     private String id;
     private String account_name;
     private double balance;
     private String account_type;

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getAccount_name() {
          return account_name;
     }

     public void setAccount_name(String account_name) {
          this.account_name = account_name;
     }

     public double getBalance() {
          return balance;
     }

     public void setBalance(double balance) {
          this.balance = balance;
     }

     public String getAccount_type() {
          return account_type;
     }

     public void setAccount_type(String account_type) {
          this.account_type = account_type;
     }

     public Account(String id, String account_name, double balance, String account_type) {
          this.id = id;
          this.account_name = account_name;
          this.balance = balance;
          this.account_type = account_type;
     }

     public Account() {
            
     }
     
     
}
