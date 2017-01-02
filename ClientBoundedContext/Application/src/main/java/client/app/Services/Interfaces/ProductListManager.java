package client.app.Services.Interfaces;

import client.domain.Aggregates.ProductAggregate.Product;

import java.util.List;


public interface ProductListManager {
    List<Product> sort();
    List<Product> filter();
    List<Product> getProducts(int amount, int page);
}
