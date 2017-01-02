package client.domain.Aggregates.OrderAggregate;

import client.domain.Aggregates.ProductAggregate.Product;
import client.domain.Aggregates.UserAggregate.Client;
import client.domain.Aggregates.OrderAggregate.OrderStates.OrderState;
import common.Interfaces.Entity;

import java.util.ArrayList;

public class Order extends Entity {

    private ArrayList<Product> products;
    private OrderAddress address;
    private Client owner;
    private OrderState state;
    private ShippingMethod shippingMethod;
    private PaymentMethod paymentMethod;

    public Order() {
    }

    public Order(int id, ArrayList<Product> products, OrderAddress address, Client owner, OrderState state,
                 ShippingMethod shippingMethod, PaymentMethod paymentMethod) {
        super(id);
        this.products = products;
        this.address = address;
        this.owner = owner;
        this.state = state;
        this.shippingMethod = shippingMethod;
        this.paymentMethod = paymentMethod;
    }

    //Probably to remove
//    public Order(int id, ArrayList<Product> products, Client owner,
//                 String name, String lastName, String street, String houseNumber, String flatNumber, String city, String postalCode, String phoneNumber) {
//        this.id = id;
//        this.products = products;
//        this.address = new OrderAddress(name, lastName, street, houseNumber, flatNumber, city, postalCode, phoneNumber);
//        this.owner = owner;
//    }
//
//    public Order(int id, OrderAddress address, Client owner) {
//        this.id = id;
//        this.products = new ArrayList<>();
//        this.address = address;
//        this.owner = owner;
//    }
//
//    public Order(int id, Client owner,
//                 String name, String lastName, String street, String houseNumber, String flatNumber, String city, String postalCode, String phoneNumber) {
//        this.id = id;
//        this.products = new ArrayList<>();
//        this.address = new OrderAddress(name, lastName, street, houseNumber, flatNumber, city, postalCode, phoneNumber);
//        this.owner = owner;
//    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
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
