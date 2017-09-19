/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.MainPage;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Åsmund
 */
@Stateless
public class MainPageFacade extends AbstractFacade<MainPage> {

    @PersistenceContext(unitName = "persistence unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MainPageFacade() {
        super(MainPage.class);
    }
    
   public double randomNum(){
       return Math.random();
   } 
    
}
