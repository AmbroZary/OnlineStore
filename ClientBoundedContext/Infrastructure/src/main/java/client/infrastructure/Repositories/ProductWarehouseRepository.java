package client.infrastructure.Repositories;



import warehouse.domain.ProductAggregate.Model;
import warehouse.domain.ProductAggregate.Product;
import warehouse.domain.ProductAggregate.Repository.MissingProductException;
import warehouse.domain.ProductAggregate.Repository.ProductRepository;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import warehouse.domain.ProductAggregate.Size;

import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

public class ProductWarehouseRepository implements ProductRepository{

    private WebResource webResource;

    public ProductWarehouseRepository() {
        Client client = Client.create();
        webResource = client.resource("http://localhost:8093");
    }

    @Override
    public void insert(Product element) {
        webResource.path("/product/add")
                .post(ClientResponse.class, element);
    }

    @Override
    public void delete(int id) {
        webResource.path("/product/delete")
                .post(ClientResponse.class, id);
    }

    @Override
    public Product find(int id) {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        params.add("id", (new Gson()).toJson(id));

        ClientResponse response = webResource.path("/product/find")
                .queryParams(params)
                .get(ClientResponse.class);

        return response.getEntity(Product.class);
    }

    @Override
    public List<Product> findAll() {
        ClientResponse response = webResource.path("/product/get-all")
                .get(ClientResponse.class);

        return (List<Product>)(response.getEntity(List.class));
    }

    @Override
    public void update(Product element) {
//        ClientResponse response = webResource.path("/product/update")
//                .post(ClientResponse.class, element);
    }

    @Override
    public Product findByModelAndSize(Model model, Size size) {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        params.add("model", (new Gson()).toJson(model));
        params.add("size", (new Gson()).toJson(size));

        ClientResponse response = webResource.path("/product/find-by-model-and-size")
                .queryParams(params)
                .get(ClientResponse.class);

        return response.getEntity(Product.class);
    }

    @Override
    public void orderProducts(int OrderId, List<Product> products) throws MissingProductException {

    }

    @Override
    public List<Product> findForOrder(int OrderId) {
        return null;
    }
}
