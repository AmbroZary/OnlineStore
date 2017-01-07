package warehouse.infrastructure.Factories.TestFactories;

import warehouse.domain.ProductAggregate.AdditionalModelInfo;
import warehouse.domain.ProductAggregate.Category;
import warehouse.domain.ProductAggregate.Model;
import warehouse.domain.ProductAggregate.Factory.ModelFactory;
import warehouse.domain.ProductAggregate.Repository.ModelRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModelTestFactory implements ModelFactory {

    private int idCounter;
    private ModelRepository modelRepository;

    public ModelTestFactory(ModelRepository modelRepository) {
        this.idCounter = 0;
        this.modelRepository = modelRepository;
    }

    @Override
    public Model createModel(String name, byte[] image, double price, Category category, List<AdditionalModelInfo> additionalModelInfo) {
        Model model = new Model(idCounter++, name, image, price, category, new HashSet<AdditionalModelInfo>(additionalModelInfo));
        modelRepository.insert(model);
        return model;
    }
}
