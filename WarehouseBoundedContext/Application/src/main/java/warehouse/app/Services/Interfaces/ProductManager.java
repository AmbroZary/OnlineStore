package warehouse.app.Services.Interfaces;


import warehouse.domain.ProductAggregate.*;
import warehouse.domain.ProductAggregate.Repository.MissingProductException;

import java.util.List;

public interface ProductManager{

    void deleteProduct(int id) ;

    Product findProduct(int id) ;

    List<Product> getAllProducts() ;

    Product AddProduct(int modelId, Size size);

    Product AddProduct(Model model, Size size);

    Product findByModelAndSize(Model model, Size size);

    void orderProducts(int orderId,List<Product> products) throws MissingProductException;
}
