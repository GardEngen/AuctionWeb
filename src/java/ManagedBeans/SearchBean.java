/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Gard
 */
@Named(value = "searchBean")
@RequestScoped
public class SearchBean {
    private String itemName;
    /**
     * Creates a new instance of SearchBean
     */
    public SearchBean() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public void searchForProduct(){
        System.out.println("itemname:: " + itemName);
    }
    
}
