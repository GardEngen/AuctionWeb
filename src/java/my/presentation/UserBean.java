/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author raugz
 */
@Named(value = "userBean")
@Dependent
public class UserBean {

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }
    
}
