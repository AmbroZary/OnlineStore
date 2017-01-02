package warehouse.domain.ProductAggregate.Factory;

import client.domain.Aggregates.ProductAggregate.AdditionalInfo;
import client.domain.Aggregates.ProductAggregate.Category;
import client.domain.Aggregates.ProductAggregate.Size;
import client.domain.Aggregates.ProductAggregate.Product;

public interface ProductFactory {
    Product createProduct(int modelId, Size size);
    Product createProduct(double price, Category category, AdditionalInfo additionalInfo, Size size);
}
