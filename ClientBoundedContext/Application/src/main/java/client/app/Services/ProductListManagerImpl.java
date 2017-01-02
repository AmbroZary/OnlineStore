package client.app.Services;

import client.domain.Aggregates.ProductAggregate.Product;
import client.domain.Aggregates.ProductAggregate.Repository.ProductRepository;
import client.app.Services.Interfaces.ProductListManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductListManagerImpl implements ProductListManager {

    private ProductRepository productRepository;

    @Autowired
    public ProductListManagerImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> sort() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> filter() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProducts(int amount, int page) {
        return productRepository.findAll();
    }
}
