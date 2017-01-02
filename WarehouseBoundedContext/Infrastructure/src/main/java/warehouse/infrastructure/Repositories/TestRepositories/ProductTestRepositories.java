package warehouse.infrastructure.Repositories.TestRepositories;

import client.domain.Aggregates.ProductAggregate.Model;
import client.domain.Aggregates.ProductAggregate.Product;
import client.domain.Aggregates.ProductAggregate.Repository.ProductRepository;
import client.domain.Aggregates.ProductAggregate.Size;
import common.Repositories.CommonTestRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductTestRepositories extends CommonTestRepository<Product> implements ProductRepository {

    @Override
    public Product findByModelAndSize(Model model, Size size) {
        return list.stream()
                .filter((Product p) -> p.getModel() == model)
                .filter((Product p)-> p.getSize() == size)
                .findFirst().orElse(null);
    }
}
