/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import EnterpriseJavaBeans.BidFacade;
import EnterpriseJavaBeans.LoginBeanRemote;
import EnterpriseJavaBeans.ProductFacade;

import Entities.Product;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author raugz
 */
@Named(value = "productView")
@SessionScoped
public class ProductView implements Serializable {


    @EJB
    private ProductFacade productFacade;
    
    @EJB
    private LoginBeanRemote serverBean;
    
    private Product product;

    private double bidVal = -1;

    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Creates a new instance of ProductView
     */
    public ProductView() {
        this.product = new Product();
    }
    
    public int getNumberOfProducts(){
        return productFacade.findAll().size();
    }
    
    public String postProduct(){
        //System.out.println("severBean from productView: " + serverBean);
        this.productFacade.create(product, serverBean.getLoggedInUser());  

        return "mainpage";
    }

    public Product getProduct() {
        return product;
    }
    public String getAllProducts(){
        return productFacade.printProductNames();
    }
        
    public String getProductName(){
        return productFacade.printProductName(0);
    }
    public String getProductDescription(){
        return productFacade.printDescription(0);
    }
    public String getProductPrice(){
        return productFacade.printPrice(0);
    }
    public String getProductSeller(){
        return productFacade.printSeller(0);
    }
    


}
