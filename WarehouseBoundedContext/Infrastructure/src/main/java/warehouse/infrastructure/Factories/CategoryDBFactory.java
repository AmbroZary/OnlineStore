package warehouse.infrastructure.Factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import warehouse.domain.ProductAggregate.Category;
import warehouse.domain.ProductAggregate.Factory.CategoryFactory;
import warehouse.domain.ProductAggregate.Repository.CategoryRepository;

import java.util.LinkedList;
import java.util.List;

@Component
public class CategoryDBFactory implements CategoryFactory{
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryDBFactory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(String name) {
        Category category = new Category(name);
        categoryRepository.insert(category);
        return category;
    }
}
