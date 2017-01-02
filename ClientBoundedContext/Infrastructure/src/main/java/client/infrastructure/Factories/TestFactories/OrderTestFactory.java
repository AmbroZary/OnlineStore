package client.infrastructure.Factories.TestFactories;

import client.domain.Aggregates.OrderAggregate.Factory.OrderFactory;
import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.OrderAddress;
import client.domain.Aggregates.OrderAggregate.OrderStates.OrderState;
import client.domain.Aggregates.OrderAggregate.PaymentMethod;
import client.domain.Aggregates.OrderAggregate.Repository.OrderRepository;
import client.domain.Aggregates.OrderAggregate.ShippingMethod;
import client.domain.Aggregates.ProductAggregate.Product;
import client.domain.Aggregates.ProductAggregate.Repository.ProductRepository;
import client.domain.Aggregates.UserAggregate.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderTestFactory extends OrderFactory {

    private int idCounter;
    private OrderRepository orderRepository;

    @Autowired
    public OrderTestFactory(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.idCounter = 0;
    }

    @Override
    protected boolean checkIfProductsAreAvailable(List<Product> products) {
        for (Product p : products) {
            if (productRepository.find(p.getId()) == null)
                return false;
        }
        return true;
    }

    @Override
    protected Order buildOrder(ArrayList<Product> products, OrderAddress address, Client client, OrderState state,
                               ShippingMethod shippingMethod, PaymentMethod paymentMethod) {
        Order order = new Order(idCounter++, products, address, client, state, shippingMethod, paymentMethod);
        saveOrder(order);
        return order;
    }

    private void saveOrder(Order order) {
        orderRepository.insert(order);
    }
}
