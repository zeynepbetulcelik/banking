/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
/**
 *
 * @author zeynep
 */
@ManagedBean
@SessionScoped
public class Registration implements Serializable{
   private String id;
   private String username;
   private String password;
   private String email;
   private String phonenumber;
   private String gender;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
   
public String confirmedRegistration() throws SQLException, NamingException{
    model.RegistrationDb registrationdb =new model.RegistrationDb() ;
    id=util.Utils.generateUUID();
boolean validate=registrationdb.CreateUser(id, username, password,  phonenumber,email, gender);
if(validate){
    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Success","You can sign-in"));
    return "index";
}

else{
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Something went wrong","Please try again"));
return "registration";
}



}
 

}
    
    
    

