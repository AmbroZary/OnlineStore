package warehouse.domain.ProductAggregate.Factory;


import client.domain.Aggregates.ProductAggregate.AdditionalInfo;
import client.domain.Aggregates.ProductAggregate.Category;
import client.domain.Aggregates.ProductAggregate.Model;

public interface ModelFactory {

    Model createModel(double price, Category category, AdditionalInfo additionalInfo);
}
