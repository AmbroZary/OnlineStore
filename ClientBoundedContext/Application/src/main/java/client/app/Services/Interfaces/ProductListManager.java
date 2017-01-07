package client.app.Services.Interfaces;



import warehouse.domain.ProductAggregate.Product;

import java.util.List;


public interface ProductListManager {
    List<Product> sort();
    List<Product> filter();
    List<Product> getProducts(int amount, int page);
}
