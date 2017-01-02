package client.domain.Aggregates.UserAggregate;

import client.domain.Aggregates.ProductAggregate.Product;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public Cart(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void AddToCart(Product product){
        products.add(product);
    }

    public void RemoveFromCard(Product product){
        if(!products.removeIf(product1 -> product == product1)){
            throw new IllegalArgumentException();
        }
    }

    public double getPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
