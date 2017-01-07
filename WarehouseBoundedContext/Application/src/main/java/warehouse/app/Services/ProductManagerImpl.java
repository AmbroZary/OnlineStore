package warehouse.app.Services;


import warehouse.domain.ProductAggregate.*;
import warehouse.domain.ProductAggregate.Repository.MissingProductException;
import warehouse.domain.ProductAggregate.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import warehouse.app.Services.Interfaces.ProductManager;
import warehouse.domain.ProductAggregate.Factory.ProductFactory;

import java.util.List;

@Component
public class ProductManagerImpl implements ProductManager {

    private ProductRepository productRepository;
    private ProductFactory productFactory;

    @Autowired
    public ProductManagerImpl(ProductRepository productRepository, ProductFactory productFactory) {
        this.productRepository = productRepository;
        this.productFactory = productFactory;
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.delete(id);
    }

    @Override
    public Product findProduct(int id) {
        return productRepository.find(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product AddProduct(int modelId, Size size) {
        return productFactory.createProduct(modelId, size);
    }

    @Override
    public Product AddProduct(Model model, Size size) {
        return productFactory.createProduct(model, size);
    }

    @Override
    public Product findByModelAndSize(Model model, Size size) {
        return productRepository.findByModelAndSize(model,size);
    }

    @Override
    public void orderProducts(int orderId, List<Product> products) throws MissingProductException{
        productRepository.orderProducts(orderId, products);
    }
}
