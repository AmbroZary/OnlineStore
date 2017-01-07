package client.infrastructure.Factories;


import client.domain.Aggregates.OrderAggregate.*;
import client.domain.Aggregates.OrderAggregate.Factory.OrderFactory;
import client.domain.Aggregates.OrderAggregate.Repository.OrderRepository;
import client.domain.Aggregates.UserAggregate.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import warehouse.domain.ProductAggregate.AdditionalModelInfo;
import warehouse.domain.ProductAggregate.Product;
import warehouse.domain.ProductAggregate.Repository.MissingProductException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Component
public class OrderDBFactory extends OrderFactory{

    private OrderRepository orderRepository;

    @Autowired
    public OrderDBFactory(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    protected Order buildOrder(Set<Product> products, OrderAddress address, Client client, OrderState state, ShippingMethod shippingMethod, PaymentMethod paymentMethod) throws MissingProductException {
        Order order = new Order(products, address, client, state, shippingMethod, paymentMethod);
        this.orderRepository.insert(order);
        return order;
    }
}
