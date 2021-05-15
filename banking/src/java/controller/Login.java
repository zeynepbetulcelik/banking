/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author zeynep
 */
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.LoginDb;
import java.sql.SQLException;
import javax.naming.NamingException;
import model.LoginDb;

import java.sql.ResultSet;

@ManagedBean(name = "login")
@SessionScoped
public class Login  {

  
    private String pwd;
    private String msg;
    private String user;
    private String id;

    public String getId() {
        return id;
    }
    
    public static String ID;
    model.LoginDb logindb;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    


    public String validateUsernamePassword() throws NamingException, SQLException {
        model.LoginDb logindb = new model.LoginDb();

        ResultSet result = logindb.kontrol_kullanici(user, pwd);

        if (result != null) {
          id=   result.getString("ID");
            return "admin";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "index";
        }
    }

    //logout event, invalidate session
    public String logout() {

        return "index";
    }

    public String Registration() {

        return "registration";
    }
}
