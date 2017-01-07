package warehouse.infrastructure.Repositories.TestRepositories;

import warehouse.domain.ProductAggregate.Model;
import common.Repositories.CommonTestRepository;
import org.springframework.stereotype.Component;
import warehouse.domain.ProductAggregate.Repository.ModelRepository;


// @Component
public class ModelTestRepository extends CommonTestRepository<Model> implements ModelRepository {
}
