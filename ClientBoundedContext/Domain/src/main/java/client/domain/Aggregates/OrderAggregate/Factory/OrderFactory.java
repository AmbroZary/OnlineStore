package client.domain.Aggregates.OrderAggregate.Factory;

import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.OrderAddress;
import client.domain.Aggregates.OrderAggregate.OrderStates.AcceptedOrderState;
import client.domain.Aggregates.OrderAggregate.OrderStates.OrderState;
import client.domain.Aggregates.OrderAggregate.PaymentMethod;
import client.domain.Aggregates.OrderAggregate.Repository.OrderRepository;
import client.domain.Aggregates.OrderAggregate.ShippingMethod;
import client.domain.Aggregates.ProductAggregate.Product;
import client.domain.Aggregates.ProductAggregate.Repository.ProductRepository;
import client.domain.Aggregates.UserAggregate.Cart;
import client.domain.Aggregates.UserAggregate.Client;

import java.util.ArrayList;
import java.util.List;


public abstract class OrderFactory {

    protected ProductRepository productRepository;

    public Order createOrder(Client client, Cart cart, String name, String lastName, String street, String houseNumber,
                             String flatNumber, String city, String postalCode, String phoneNumber, String email,
                             ShippingMethod shippingMethod, PaymentMethod paymentMethod) {
        if (checkIfProductsAreAvailable(cart.getProducts())) {
            DeleteProductsFromRepository(cart.getProducts());
            return buildOrder(cart.getProducts(), new OrderAddress(name, lastName, street, houseNumber,
                    flatNumber, city, postalCode, phoneNumber, email), client, new AcceptedOrderState(), shippingMethod, paymentMethod);
        }
        return null;
    }

    protected abstract Order buildOrder(ArrayList<Product> products, OrderAddress address, Client client, OrderState state,
                                        ShippingMethod shippingMethod, PaymentMethod paymentMethod);

    protected abstract boolean checkIfProductsAreAvailable(List<Product> products);

    private void DeleteProductsFromRepository(List<Product> products) {
        for (Product p : products) {
            productRepository.delete(p.getId());
        }
    }

}
