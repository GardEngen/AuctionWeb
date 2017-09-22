/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import EnterpriseJavaBeans.ProductFacade;
import Entities.Product;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author raugz
 */
@Named(value = "productView")
@RequestScoped
public class ProductView {

    @EJB
    private ProductFacade productFacade;
    private Product product;

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
        this.productFacade.create(product);
        return "mainpage";
    }

    public Product getProduct() {
        return product;
    }
    
        public String getAllProducts(){
        return productFacade.printProductNames();
    }
}
