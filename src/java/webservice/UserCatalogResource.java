/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import entities.BooleanResult;
import entities.User;
import java.util.ArrayList;
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
    public BooleanResult login(@QueryParam("username") String username, @QueryParam("password") String password) {

        if (username != null && password != null) {
            UserCatalog ctl = new UserCatalog();
            return ctl.login(username, password);
        }
        return new BooleanResult(false);
    }
    
    @GET
    @Path("userregister")
    @Produces(MediaType.APPLICATION_JSON)
    public BooleanResult register(@QueryParam("username") String username, @QueryParam("password") String password, @QueryParam("email") String email){
        if(username != null && password != null && email != null){
            UserCatalog ctl = new UserCatalog();
            return  ctl.register(username, password, email);
        }
        return new BooleanResult(false);
    }
}
