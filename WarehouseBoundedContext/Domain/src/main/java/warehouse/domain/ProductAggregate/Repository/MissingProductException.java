package warehouse.domain.ProductAggregate.Repository;

import warehouse.domain.ProductAggregate.Product;

import java.util.List;

public class MissingProductException extends Exception {
    private List<Product> products;

    public MissingProductException(List<Product> products) {
        this.products = products;
    }
}
