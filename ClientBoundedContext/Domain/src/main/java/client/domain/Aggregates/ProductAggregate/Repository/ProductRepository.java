package client.domain.Aggregates.ProductAggregate.Repository;

import client.domain.Aggregates.ProductAggregate.Model;
import client.domain.Aggregates.ProductAggregate.Product;
import client.domain.Aggregates.ProductAggregate.Size;
import common.Repositories.CommonRepository;

public interface ProductRepository extends CommonRepository<Product> {
    Product findByModelAndSize(Model model, Size size);
}
