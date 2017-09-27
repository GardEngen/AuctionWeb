/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnterpriseJavaBeans;

import Entities.AuctionUser;
import javax.ejb.Stateful;

/**
 *
 * @author raugz
 */
@Stateful
public class LoginBean implements LoginBeanRemote {
    private AuctionUser user;

    @Override
    public Boolean login(String username, String password) {
        //TODO checks on info from db etc
        
        user = new AuctionUser();
        user.setName(username);
        user.setPassword(password);
        return true;
    }

    @Override
    public AuctionUser getLoggedInUser() {
        return user;
    }
    
}
