/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import entity.Person;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.DetailDb;

/**
 *
 * @author zeynep
 */
@ManagedBean(name = "accountscontroller")
@SessionScoped

public class Accountscontroller {

     private Account account;

     private DetailDb detaildb;

     public Accountscontroller() {
          this.account = new Account();

          this.detaildb = new DetailDb();

     }

     public Account getAccount() {
          return account;
     }

     public void setAccount(Account account) {
          this.account = account;
     }

     public DetailDb getDetaildb() {
          return detaildb;
     }

     public void setDetaildb(DetailDb detaildb) {
          this.detaildb = detaildb;
     }

     public String createAccount(String id) {
          detaildb.registAccount(account.getAccount_name(), account.getAccount_type(), id);

          return "newaccount";
     }

     public String showAccounts() {

          return "showbalance";
     }

}
