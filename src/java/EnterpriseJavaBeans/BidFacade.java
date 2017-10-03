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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Åsmund
 */
@Stateless
public class BidFacade extends AbstractFacade<Bid> {

    @PersistenceContext(unitName = "persistence unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BidFacade() {
        super(Bid.class);
    }
    
    public Bid createBid(double amount, Product product, AuctionUser user){
        Bid b = new Bid(); 
            
        b.setAmount(amount);
        b.setProduct(product);
        b.setBuyer(user);
        
        create(b);
        
        //warning: slow for users with many bids!
        if(!b.getBuyer().getBids().contains(b)){
            b.getBuyer().getBids().add(b);
                    
        }
            
        if(!b.getProduct().getBids().contains(b)){
        b.getProduct().getBids().add(b);
        }
                
        product.setStartingPrice(amount);
        
        return b;
    }

    
}
