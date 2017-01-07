package client.domain.Aggregates.OrderAggregate.Factory;

import client.domain.Aggregates.OrderAggregate.*;
import client.domain.Aggregates.OrderAggregate.Repository.OrderRepository;
import client.domain.Aggregates.UserAggregate.Cart;
import client.domain.Aggregates.UserAggregate.Client;
import warehouse.domain.ProductAggregate.AdditionalModelInfo;
import warehouse.domain.ProductAggregate.Product;
import warehouse.domain.ProductAggregate.Repository.MissingProductException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public abstract class OrderFactory {


    public Order createOrder(Client client, Cart cart, String name, String lastName, String street, String houseNumber,
                             String flatNumber, String city, String postalCode, String phoneNumber, String email,
                             ShippingMethod shippingMethod, PaymentMethod paymentMethod) throws MissingProductException {
        return buildOrder(new HashSet<Product>(cart.getProducts()), new OrderAddress(name, lastName, street, houseNumber,
                flatNumber, city, postalCode, phoneNumber, email), client, OrderState.Accepted, shippingMethod, paymentMethod);
    }

    protected abstract Order buildOrder(Set<Product> products, OrderAddress address, Client client, OrderState state,
                                        ShippingMethod shippingMethod, PaymentMethod paymentMethod) throws MissingProductException;

}
