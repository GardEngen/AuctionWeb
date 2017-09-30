/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterpriseJavaBeans;

import Entities.AuctionUser;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author raugz
 */
@Stateless
public class LoginBean extends AbstractFacade<AuctionUser>{

    public LoginBean() {
        super(AuctionUser.class);
    }
    
    // or use em from UserFacade?
    @PersistenceContext(unitName = "persistence unit")
    private EntityManager em;
    

    public Boolean login(String username, String password) {
        if(inputMatchesDBList(username, password, dbQueryAllUsers())){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    private List dbQueryAllUsers() {
        List userList = findAll();
        return userList;
    }
    
    private Boolean inputMatchesDBList(String usr, String pw, List<AuctionUser> l){
        for(AuctionUser u : l){
            if((u.getName().equals(usr)) && (u.getPassword().equals(pw))){
                return true;
            }
        }
        return false;
    }
    
}
