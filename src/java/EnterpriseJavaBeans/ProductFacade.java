/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterpriseJavaBeans;

import EnterpriseJavaBeans.AbstractFacade;
import Entities.AuctionUser;
import Entities.Bid;
import Entities.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
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
    
    @EJB
    private LoginBeanRemote serverBean;
    
    @Override
    public void create(Product entity) {
        
        if(serverBean.getLoggedInUser() == null){
            System.out.println("It is null");
        }
        /*
        LoginBeanRemote bean = null;
        Context myCurretContex = null;
        try{
         myCurretContex = new InitialContext();
         bean = (LoginBeanRemote)  myCurretContex.lookup("java:global/AuctionWeb/LoginBean!EnterpriseJavaBeans.LoginBeanRemote");
        }catch(Exception e){
               System.out.println(e.getMessage());
        }
        */
        
        /*
        Bid b = new Bid();
        b.setAmount((double) 0);
        b.setProduct(entity);
        entity.getBids().add(b);
        */
        
        addUserToProduct(entity);
        //entity.setSeller(serverBean.getLoggedInUser());
        getEntityManager().persist(entity);
        if(!entity.getSeller().getProducts().contains(entity)){
            entity.getSeller().getProducts().add(entity);
        }

    }
    
    public void create(Product entity, AuctionUser u){
        entity.setSeller(u);
        //entity.setSeller(serverBean.getLoggedInUser());
        getEntityManager().persist(entity);
        if(!entity.getSeller().getProducts().contains(entity)){
            entity.getSeller().getProducts().add(entity);
        }   
    }
    
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
                   ", for: " + a.getStartingPrice() + "." + "<br/>" +a.getSeller().getName()  +"<br/>";
        }
        return out;
    }
    
    public String allProductInfo(){
        String out = "";
        return out;
    }

    public void addUserToProduct(Product p) {
        AuctionUser u = findFirstUser();
        if(!u.getProducts().contains(p))
            p.setSeller(u);
    }
    
    public AuctionUser findFirstUser() {
        List a = em.createQuery(
        "SELECT c FROM AuctionUser c").getResultList();
        return (AuctionUser) a.get(0);
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
            //out += products.get(index).getCurrentBid().getAmount();
        }
        return out;
    }
    public String printSeller(int index){
        String out = "";
        List<Product> products= findAll(); 
        if(index < products.size()){
            out += products.get(index).getSeller().getName();
        }
        return out;
    }
}
