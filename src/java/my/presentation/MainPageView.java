/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.MainPageFacade;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Åsmund
 */
@Named(value = "mainPage")
@RequestScoped
public class MainPageView {

    @EJB
    private MainPageFacade mainface;
    
    /**
     * Creates a new instance of MainPage
     */
    public MainPageView() {
    }
    
    public String random(){
         return "" + mainface.randomNum();
    }
    
    public String nextPage(){
        return "mainpage";
    }
}
