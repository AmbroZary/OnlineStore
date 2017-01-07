package client.domain.Aggregates.OrderAggregate;


import client.domain.Aggregates.UserAggregate.Client;
import common.Interfaces.Entity;
import warehouse.domain.ProductAggregate.Product;

import java.util.ArrayList;
import java.util.Set;

public class Order extends Entity {

    private Set<Product> products;
    private OrderAddress address;
    private Client owner;
    private OrderState state;
    private ShippingMethod shippingMethod;
    private PaymentMethod paymentMethod;

    public Order() {
    }

    public Order(int id, Set<Product> products, OrderAddress address, Client owner, OrderState state,
                 ShippingMethod shippingMethod, PaymentMethod paymentMethod) {
        super(id);
        this.products = products;
        this.address = address;
        this.owner = owner;
        this.state = state;
        this.shippingMethod = shippingMethod;
        this.paymentMethod = paymentMethod;
    }

    public Order(Set<Product> products, OrderAddress address, Client owner, OrderState state,
                 ShippingMethod shippingMethod, PaymentMethod paymentMethod) {
        this.products = products;
        this.address = address;
        this.owner = owner;
        this.state = state;
        this.shippingMethod = shippingMethod;
        this.paymentMethod = paymentMethod;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public OrderAddress getAddress() {
        return address;
    }

    public void setAddress(OrderAddress address) {
        this.address = address;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public double getPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
