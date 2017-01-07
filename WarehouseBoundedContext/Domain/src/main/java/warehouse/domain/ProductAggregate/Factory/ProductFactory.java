package warehouse.domain.ProductAggregate.Factory;

import warehouse.domain.ProductAggregate.*;

import java.util.List;

public interface ProductFactory {
    Product createProduct(int modelId, Size size);
    Product createProduct(Model model, Size size);
}
