/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.AuctionUser;
import entities.Product;
import java.util.List;
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
           out += "Product: " + a.getName() +
                   ", for: " + a.getCurrentPrice() + "." + "<br/>" +a.getSeller().getName()  +"<br/>";
        }
        return out;
    }
    
    public String allProductInfo(){
        String out = "";
        return out;
    }

    public void addUserToProduct(Product p) {
       p.setSeller(findFirstUser());
    }
    
    public AuctionUser findFirstUser() {
        return (AuctionUser) em.createQuery(
        "SELECT c FROM AuctionUser c").getResultList().get(0);
    }
    
        
    public String printProductName(int index){
        String out = "";
        List<Product> products= findAll();
        if(products.size() > index){
            out+=products.get(index).getName();
        }
        return out;
    }
    
    public String printDescription(int index){
        String out = "";
        List<Product> products= findAll(); 
        if(index < products.size()){
            out += products.get(index).getDescription();
        }
        return out;
    }
    
        public String printPrice(int index){
        String out = "";
        List<Product> products= findAll(); 
        if(index < products.size()){
            out += products.get(index).getCurrentPrice();
        }
        return out;
    }
}
