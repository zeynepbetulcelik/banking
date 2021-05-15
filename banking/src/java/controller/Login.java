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


import java.sql.SQLException;
import javax.naming.NamingException;
import model.LoginDb;


@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	
	private String pwd;
	private String msg;
	private String user;
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
                    public static String username;
	//validate login
                    
	public String validateUsernamePassword() throws NamingException, SQLException {
		model.LoginDb logindao=new model.LoginDb() ;
               boolean valid= logindao.kontrol_kullanici(user, pwd);
               username=user;
                   // ID=logindb.getID();
		if (valid) {
			
			
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
        public String Registration(){

    return "registration";
}
}