/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import EnterpriseJavaBeans.LoginBean;
import EnterpriseJavaBeans.LoginBeanRemote;
import Entities.AuctionUser;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Gard
 */
@Named(value = "loginClient")
@SessionScoped
public class LoginBeanClient implements Serializable{

    @EJB
    private LoginBeanRemote serverBean;
    
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Use this to get currently inlogged user
     * TODO somewhere check if user is logged on to avoid nullpointers
     * @return 
     */
    public AuctionUser getUser() {
        return serverBean.getLoggedInUser();
    }
    
    public void login(){
        //Todo options if authentication fails
        serverBean.login(userName, password); // returns boolean value
    }
    
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBeanClient() {
    }
    
    /*
    public void login(){
        System.out.println("username::" + serverBean.getLoggedInUser().getName());
              System.out.println("pw::" + serverBean.getLoggedInUser().getPassword());
    }
    */
    
}
