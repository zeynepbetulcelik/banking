/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Person;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.PersonDb;
import model.DetailDb;

/**
 *
 * @author zeynep
 */
@ManagedBean(name = "personcontroller")
@SessionScoped
public class Personcontroller {

     private PersonDb persondb;
     private Person person;
     private DetailDb detaildb;
     private double miktar;

    public double getMiktar() {
        return miktar;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }
     public Personcontroller() {
          this.person = new Person();
          this.persondb = new PersonDb();
          Person.PersonInstance = this.person;
          this.detaildb = new DetailDb();
          this.miktar = miktar;
     }

    public DetailDb getDetaildb() {
        return detaildb;
    }

    public void setDetaildb(DetailDb detaildb) {
        this.detaildb = detaildb;
    }
     

     public PersonDb getPersondb() {
          return persondb;
     }

     public void setPersondb(PersonDb persondb) {
          this.persondb = persondb;
     }

     public Person getPerson() {
          return person;
     }

     public void setPerson(Person person) {
          this.person = person;
     }

     public String Login() throws ClassNotFoundException, SQLException {
          person.PersonInstance = persondb.login(this.person);
          if (person.PersonInstance.getId() != null) {
               detaildb.updatetotalbalance();
               return "admin";
          } else {
               return "index";
          }

     }

     public String Registration() {
          return "registration";
     }

     public String Register() throws ClassNotFoundException {
          boolean valid = persondb.register(person);
          if (valid) {
               return "index";
          } else {
               return "registration";
          }
     }
     
        public String exit(){
           Person.PersonInstance = null;
           Person.UserInstance = null;
           return "index";
       }
        
        public String payBill(String type) throws SQLException{
           boolean valid1 = detaildb.payBill(type, miktar);
           
            if(valid1){
               return "payBills";
           } else{
                return "payBills";
            }
        }
        
        public String deleteAccount(String account_id) throws SQLException {
            boolean valid2 = detaildb.deleteAccount(account_id);
            
            if(valid2){
                return "deleteaccount";
            }
            else{
                return "deleteaccount";
            }
        }
            
        }
