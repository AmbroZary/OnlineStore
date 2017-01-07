package warehouse.infrastructure.Repositories.TestRepositories;

import warehouse.domain.ProductAggregate.Model;
import warehouse.domain.ProductAggregate.Product;
import warehouse.domain.ProductAggregate.Repository.MissingProductException;
import warehouse.domain.ProductAggregate.Repository.ProductRepository;
import warehouse.domain.ProductAggregate.Size;
import common.Repositories.CommonTestRepository;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

// @Component
public class ProductTestRepository extends CommonTestRepository<Product> implements ProductRepository {

    @Override
    public Product findByModelAndSize(Model model, Size size) {
        return list.stream()
                .filter((Product p) -> p.getModel() == model)
                .filter((Product p)-> p.getSize() == size)
                .findFirst().orElse(null);
    }

    @Override
    public void orderProducts(int id, List<Product> products) throws MissingProductException {
        List<Product> missings = new LinkedList<>();
        for (Product ordered:products) {
            if(list.stream().filter((Product p) -> p == ordered).findFirst().orElse(null) == null){
                missings.add(ordered);
            }
        }
        if (!missings.isEmpty()){
            throw new MissingProductException(missings);
        }
    }

    @Override
    public List<Product> findForOrder(int OrderId) {
        return list;
    }
}
