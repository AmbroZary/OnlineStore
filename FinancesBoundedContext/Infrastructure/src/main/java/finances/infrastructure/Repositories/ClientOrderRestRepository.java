package finances.infrastructure.Repositories;

import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.OrderStates.PaidOrderState;
import client.domain.Aggregates.ProductAggregate.Product;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import finances.domain.Services.ClientOrderRepository;

import javax.ws.rs.core.MultivaluedMap;


public class ClientOrderRestRepository implements ClientOrderRepository{

    private WebResource webResource;

    public ClientOrderRestRepository() {
        Client client = Client.create();
        webResource = client.resource("http://localhost:8090");
    }

    //TODO change port and paths
    @Override
    public Order getOrder(int id) {
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        params.add("id", (new Gson()).toJson(id));

        ClientResponse response = webResource.path("/order/get")
                .queryParams(params)
                .get(ClientResponse.class);

        return response.getEntity(Order.class);
    }

    @Override
    public void changeState(int id) {
        webResource.path("state/paid")
                .post(ClientResponse.class);
    }
}
