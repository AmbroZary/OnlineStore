package warehouse.infrastructure.Factories.TestFactories;

import client.domain.Aggregates.ProductAggregate.AdditionalInfo;
import client.domain.Aggregates.ProductAggregate.Category;
import client.domain.Aggregates.ProductAggregate.Model;
import warehouse.domain.ProductAggregate.Factory.ModelFactory;
import warehouse.domain.ProductAggregate.Repository.ModelRepository;

public class ModelTestFactory implements ModelFactory {

    private int idCounter;
    private ModelRepository modelRepository;

    public ModelTestFactory(ModelRepository modelRepository) {
        this.idCounter = 0;
        this.modelRepository = modelRepository;
    }

    @Override
    public Model createModel(double price, Category category, AdditionalInfo additionalInfo) {
        Model model = new Model(idCounter++,price,category,additionalInfo);
        modelRepository.insert(model);
        return model;
    }
}
