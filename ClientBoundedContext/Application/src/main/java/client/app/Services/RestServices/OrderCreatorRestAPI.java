package client.app.Services.RestServices;

import client.app.Services.Interfaces.OrderCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderCreatorRestAPI {

    @Autowired
    public OrderCreatorRestAPI(OrderCreator orderCreator) {
        this.orderCreator = orderCreator;
    }

    private OrderCreator orderCreator;
}
