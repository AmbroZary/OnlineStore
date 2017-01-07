package client.domain.Aggregates.UserAggregate;


import warehouse.domain.ProductAggregate.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Cart {
    private Set<Product> products;

    public Cart() {
        products = new HashSet<>();
    }

    public Cart(Set<Product> products) {
        this.products = products;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
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
