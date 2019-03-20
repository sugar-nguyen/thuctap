
package webservice;
import entities.Devices;
import java.util.*;
import model.UserCatalog.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import model.Product;
import model.Status;
import model.UserCatalog;

@Path("productcatalog")
public class ProductCatalogResource {

    private static List<Product> productCatalog;

    public ProductCatalogResource() {
        initializeProductCatalog();
    }
    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Product[] listCategory() {
     return (Product[]) productCatalog.toArray(new Product[productCatalog.size()]);
    }
    @GET
    @Path("search/category/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product[] searchByCategory(@PathParam("category") String category) {

        List products = new ArrayList();

        for (Product p : productCatalog) {
            if (category != null && category.equalsIgnoreCase(p.getCategory())) {
                products.add(p);
            }
        }

        return (Product[]) products.toArray(new Product[products.size()]);
    }
    
    
   
    @GET
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public Product[] searchByName(@QueryParam("name") String name) {

        List products = new ArrayList();

        for (Product p : productCatalog) {
            if (name != null && name.toLowerCase().startsWith(p.getName().toLowerCase())) {
                products.add(p);
            }
        }

        return (Product[]) products.toArray(new Product[products.size()]);
    }
    
    @POST
    @Path("insert")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Status insert(Product product) {
        productCatalog.add(product);
        return new Status("SUCCESS", "Inserted " + product.getName());
    }

    private void initializeProductCatalog() {
        if (productCatalog == null) {
            productCatalog = new ArrayList<Product>();
            productCatalog.add(new Product(1, "Keyboard", "Electronics", 29.99D));
            productCatalog.add(new Product(2, "Mouse", "Electronics", 9.95D));
            productCatalog.add(new Product(3, "17\" Monitor", "Electronics", 159.49D));
            productCatalog.add(new Product(4, "Hammer", "Hardware", 9.95D));
            productCatalog.add(new Product(5, "Screwdriver", "Hardware", 7.95D));
            productCatalog.add(new Product(6, "English Dictionary", "Books", 11.39D));
            productCatalog.add(new Product(7, "A House in Bali", "Books", 15.99D));
            productCatalog.add(new Product(8, "An Alaskan Odyssey", "Books", 799.99D));
            productCatalog.add(new Product(9, "LCD Projector", "Electronics", 1199.19D));
            productCatalog.add(new Product(10, "Smart Thermostat", "Electronics", 1199.19D));
        }
    }
}

