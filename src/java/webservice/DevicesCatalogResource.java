/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import entities.Devices;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.UserCatalog;

@Path("devicescatalog")
public class DevicesCatalogResource {

    @GET
    @Path("getdsdevices")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Devices> getdsDV() {
        UserCatalog ctl = new UserCatalog();
        return ctl.getList();
    }

}
