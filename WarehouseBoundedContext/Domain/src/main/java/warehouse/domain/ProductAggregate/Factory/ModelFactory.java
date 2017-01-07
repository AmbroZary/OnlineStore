package warehouse.domain.ProductAggregate.Factory;


import warehouse.domain.ProductAggregate.AdditionalModelInfo;
import warehouse.domain.ProductAggregate.Category;
import warehouse.domain.ProductAggregate.Model;

import java.util.List;

public interface ModelFactory {
    Model createModel(String name, byte[] image, double price, Category category, List<AdditionalModelInfo> additionalModelInfo);
}
