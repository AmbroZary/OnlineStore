package client.app.Services.Interfaces;

import client.domain.Aggregates.UserAggregate.Cart;
import client.domain.Aggregates.UserAggregate.Client;
import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.PaymentMethod;
import client.domain.Aggregates.OrderAggregate.ShippingMethod;

public interface OrderCreator {
    Order createOrder(Client client, Cart cart, String name, String lastName, String street, String houseNumber,
                      String flatNumber, String city, String postalCode, String phoneNumber, String email, ShippingMethod shippingMethod, PaymentMethod paymentMethod);
}
