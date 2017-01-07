package client.infrastructure.Factories.TestFactories;

import client.domain.Aggregates.OrderAggregate.Factory.OrderFactory;
import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.OrderAddress;
import client.domain.Aggregates.OrderAggregate.OrderState;
import client.domain.Aggregates.OrderAggregate.PaymentMethod;
import client.domain.Aggregates.OrderAggregate.Repository.OrderRepository;
import client.domain.Aggregates.OrderAggregate.ShippingMethod;

import client.domain.Aggregates.UserAggregate.Cart;
import warehouse.domain.ProductAggregate.AdditionalModelInfo;
import warehouse.domain.ProductAggregate.Product;
import warehouse.domain.ProductAggregate.Repository.MissingProductException;
import warehouse.domain.ProductAggregate.Repository.ProductRepository;
import client.domain.Aggregates.UserAggregate.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// @Component
public class OrderTestFactory extends OrderFactory {

    private int idCounter;
    private OrderRepository orderRepository;

    // @Autowired
    public OrderTestFactory(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.idCounter = 0;
    }


    @Override
    protected Order buildOrder(Set<Product> products, OrderAddress address, Client client, OrderState state,
                               ShippingMethod shippingMethod, PaymentMethod paymentMethod) throws MissingProductException{
        Order order = new Order(idCounter++, products, address, client, state, shippingMethod, paymentMethod);
        this.orderRepository.insert(order);
        return order;
    }

}
