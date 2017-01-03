package client.app.Services.RestServices;

import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderManagerRestAPI {

    private OrderRepository orderRepository;

    @Autowired
    public OrderManagerRestAPI(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping(value = "order/get", method = RequestMethod.GET)
    public ResponseEntity<Order> getOrder(int id){
        return new ResponseEntity<Order>(orderRepository.find(id), HttpStatus.OK);
    }
}
