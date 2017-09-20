/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.Product;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author raugz
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "persistence unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }
    
    public String printProductNames(){
        String out ="";
        for(Product a : findAll()){
           out += "Product: " + a.getName() + ", Sold by: " + a.getSeller() +
                   ", for: " + a.getCurrentPrice() + "." + "<br/><br/>"  ;
        }
        return out;
    }
    
    public String allProductInfo(){
        String out = "";
        return out;
    }
}
