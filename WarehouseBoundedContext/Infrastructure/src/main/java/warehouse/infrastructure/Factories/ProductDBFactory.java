package warehouse.infrastructure.Factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import warehouse.domain.ProductAggregate.*;
import warehouse.domain.ProductAggregate.Factory.ProductFactory;
import warehouse.domain.ProductAggregate.Repository.ModelRepository;
import warehouse.domain.ProductAggregate.Repository.ProductRepository;

import java.util.List;

@Component
public class ProductDBFactory implements ProductFactory{

    private ProductRepository productRepository;
    private ModelRepository modelRepository;

    @Autowired
    public ProductDBFactory(ProductRepository productRepository, ModelRepository modelRepository) {
        this.productRepository = productRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public Product createProduct(int modelId, Size size) {
        Model model = modelRepository.find(modelId);
        return createProduct(model,size);
    }

    @Override
    public Product createProduct(Model model, Size size) {
        Product product = new Product(model,size);
        this.productRepository.insert(product);
        return product;
    }

}
