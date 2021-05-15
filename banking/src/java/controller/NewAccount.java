/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.NamingException;
import static controller.Login.ID;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author omerc
 */

@ManagedBean (name="sample")
@SessionScoped

public class NewAccount  implements Serializable{
    private String account_type;
    private String account_name;
      
    
    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }
    public String getAccount_type() {
        return account_type;
    }

    
   public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }
    public String getAccount_name() {
        return account_name;
    }

 

public String confirmedNewAccount() throws SQLException, NamingException{
    model.NewAccountDb newaccountdb =new model.NewAccountDb();
boolean validate=newaccountdb.NewAccount(ID, account_type ,account_name);
if(validate){
    FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Success","Hesabınız başarıyla açıldı."));
    return "newaccount";
}

else{
FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Something went wrong","Please try again"));
return "newaccount";
}
}


}

