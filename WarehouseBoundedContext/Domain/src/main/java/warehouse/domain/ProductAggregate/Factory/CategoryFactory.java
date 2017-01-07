package warehouse.domain.ProductAggregate.Factory;

import warehouse.domain.ProductAggregate.Category;

public interface CategoryFactory {
    Category createCategory(String name);
}
