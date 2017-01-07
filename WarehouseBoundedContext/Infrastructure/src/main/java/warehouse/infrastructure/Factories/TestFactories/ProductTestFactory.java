package warehouse.infrastructure.Factories.TestFactories;

import warehouse.domain.ProductAggregate.*;
import warehouse.domain.ProductAggregate.Repository.ProductRepository;
import warehouse.domain.ProductAggregate.Factory.ModelFactory;
import warehouse.domain.ProductAggregate.Factory.ProductFactory;
import warehouse.domain.ProductAggregate.Repository.ModelRepository;

import java.util.List;


public class ProductTestFactory implements ProductFactory {

    private ModelFactory modelFactory;
    private ModelRepository modelRepository;
    private ProductRepository productRepository;

    public ProductTestFactory(ModelFactory modelFactory, ModelRepository modelRepository, ProductRepository productRepository) {
        this.modelFactory = modelFactory;
        this.modelRepository = modelRepository;
        this.productRepository = productRepository;
        this.idCounter = 0;
    }

    private int idCounter;


    @Override

    public Product createProduct(int modelId, Size size) {
        Product product = new Product(idCounter++,modelRepository.find(modelId), size);
        productRepository.insert(product);
        return product;
    }

    @Override
    public Product createProduct(Model model, Size size) {
        Product product = new Product(idCounter++,model, size);
        productRepository.insert(product);
        return product;
    }
}
