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

/**
 *
 * @author zeynep
 */
@ManagedBean(name = "personcontroller")
@SessionScoped
public class Personcontroller {

     private PersonDb persondb;
     private Person person;

     public Personcontroller() {
          this.person = new Person();
          this.persondb = new PersonDb();
          Person.PersonInstance = this.person;

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

}
