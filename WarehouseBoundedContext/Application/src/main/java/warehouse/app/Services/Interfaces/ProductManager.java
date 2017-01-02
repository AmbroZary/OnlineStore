package warehouse.app.Services.Interfaces;


import client.domain.Aggregates.ProductAggregate.*;

import java.util.List;

public interface ProductManager{

    public void deleteProduct(int id) ;

    public Product findProduct(int id) ;

    public List<Product> getAllProducts() ;

    public Product AddProduct(int modelId, Size size);

    public Product AddProduct(double price, Category category, AdditionalInfo additionalInfo, Size size);

    public Product findByModelAndSize(Model model, Size size);
}
