package warehouse.infrastructure.Factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import warehouse.domain.ProductAggregate.AdditionalModelInfo;
import warehouse.domain.ProductAggregate.Category;
import warehouse.domain.ProductAggregate.Factory.ModelFactory;
import warehouse.domain.ProductAggregate.Model;
import warehouse.domain.ProductAggregate.Repository.ModelRepository;

import java.util.HashSet;
import java.util.List;

@Component
public class ModelDBFactory implements ModelFactory {
    private ModelRepository modelRepository;

    @Autowired
    public ModelDBFactory(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model createModel(String name, byte[] image, double price, Category category, List<AdditionalModelInfo> additionalModelInfo) {
        Model model = new Model(name, image, price, category, new HashSet<AdditionalModelInfo>(additionalModelInfo));
        this.modelRepository.insert(model);
        return model;
    }
}
