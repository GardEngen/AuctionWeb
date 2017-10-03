/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import EnterpriseJavaBeans.ProductFacade;
import Entities.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
    private List<Product> searchResult;

    @EJB
    private ProductFacade productFacade;

    /**
     * Creates a new instance of SearchBean
     */
    public SearchBean() {
        this.searchResult = new ArrayList();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public String searchForProduct(){
         if( productFacade.searchForProduct(itemName).isEmpty()){
             return "Du fant ingenitng";
         } else {
            this.searchResult =productFacade.searchForProduct(itemName);
           return "listProducts";
         }
    }
     public List<Product> getResult() {
        return searchResult;
    }
   


}
