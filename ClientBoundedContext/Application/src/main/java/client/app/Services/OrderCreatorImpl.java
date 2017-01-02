package client.app.Services;

import client.domain.Aggregates.OrderAggregate.Repository.OrderRepository;
import client.domain.Aggregates.ProductAggregate.Repository.ProductRepository;
import client.domain.Aggregates.UserAggregate.Cart;
import client.domain.Aggregates.UserAggregate.Client;
import client.domain.Aggregates.OrderAggregate.Factory.OrderFactory;
import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.PaymentMethod;
import client.domain.Aggregates.OrderAggregate.ShippingMethod;
import client.app.Services.Interfaces.OrderCreator;
import client.infrastructure.Services.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatorImpl implements OrderCreator{

    private EmailSender emailSender;
    private OrderFactory orderFactory;
    private ProductRepository productRepository;

    @Autowired
    public OrderCreatorImpl(EmailSender emailSender, OrderFactory orderFactory, ProductRepository productRepository) {
        this.emailSender = emailSender;
        this.orderFactory = orderFactory;
    }

    @Override
    public Order createOrder(Client client, Cart cart, String name, String lastName, String street, String houseNumber,
                             String flatNumber, String city, String postalCode, String phoneNumber, String email, ShippingMethod shippingMethod,
                             PaymentMethod paymentMethod) {
        Order order = orderFactory.createOrder(client,cart,name,lastName,street,houseNumber,flatNumber,city,postalCode,phoneNumber,email,
                shippingMethod,paymentMethod);
        emailSender.sendEmail(email, String.format("Zamowienie numer %1$s zostało złożone", order.getId()), "Twoje zamówienie zostało złożone. Czekaj na dalsze informacje");
        return order;
    }
}
