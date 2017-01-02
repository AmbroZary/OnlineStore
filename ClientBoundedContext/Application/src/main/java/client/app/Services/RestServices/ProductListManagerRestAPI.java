package client.app.Services.RestServices;

import client.domain.Aggregates.ProductAggregate.Product;
import client.app.Services.Interfaces.ProductListManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductListManagerRestAPI {

    private ProductListManager productListManager;

    @Autowired
    public ProductListManagerRestAPI(ProductListManager productListManager) {
        this.productListManager = productListManager;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProducts(){
        return  new ResponseEntity<List<Product>>(productListManager.getProducts(0,0), HttpStatus.OK);
    }
}
