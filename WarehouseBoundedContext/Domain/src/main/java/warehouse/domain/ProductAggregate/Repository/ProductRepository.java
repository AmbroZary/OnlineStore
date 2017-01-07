package warehouse.domain.ProductAggregate.Repository;

import warehouse.domain.ProductAggregate.Model;
import warehouse.domain.ProductAggregate.Product;
import warehouse.domain.ProductAggregate.Size;
import common.Repositories.CommonRepository;

import java.util.List;

public interface ProductRepository extends CommonRepository<Product> {
    Product findByModelAndSize(Model model, Size size);
    void orderProducts(int OrderId, List<Product> products) throws MissingProductException;
    List<Product> findForOrder(int OrderId);
}
