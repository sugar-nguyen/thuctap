/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import entities.User;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import model.*;

@Path("usercatalog")
public class UserCatalogResource {

    @GET
    @Path("getlistuser")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getListUser() {
        UserCatalog ctl = new UserCatalog();
        return ctl.getListUser();
    }

    @GET
    @Path("userlogin")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean login(@QueryParam("username") String username) {
        if (username != null) {
            UserCatalog ctl = new UserCatalog();
            return ctl.login(username);
        }
        return false;
    }
}
