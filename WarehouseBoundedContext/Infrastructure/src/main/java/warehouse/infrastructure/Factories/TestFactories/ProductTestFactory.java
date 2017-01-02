package warehouse.infrastructure.Factories.TestFactories;

import client.domain.Aggregates.ProductAggregate.AdditionalInfo;
import client.domain.Aggregates.ProductAggregate.Category;
import client.domain.Aggregates.ProductAggregate.Product;
import client.domain.Aggregates.ProductAggregate.Repository.ProductRepository;
import client.domain.Aggregates.ProductAggregate.Size;
import warehouse.domain.ProductAggregate.Factory.ModelFactory;
import warehouse.domain.ProductAggregate.Factory.ProductFactory;
import warehouse.domain.ProductAggregate.Repository.ModelRepository;


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
    public Product createProduct(double price, Category category, AdditionalInfo additionalInfo, Size size) {
        Product product = new Product(idCounter++, modelFactory.createModel(price,category,additionalInfo), size);
        productRepository.insert(product);
        return product;
    }
}
