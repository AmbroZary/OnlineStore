package warehouse.app.Services.RestServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import warehouse.app.Services.Interfaces.ProductManager;
import warehouse.domain.ProductAggregate.*;
import warehouse.domain.ProductAggregate.Repository.MissingProductException;

import java.util.LinkedList;
import java.util.List;

@RestController
public class ProductManagerRestAPI {

    private ProductManager productManager;

    @Autowired
    public ProductManagerRestAPI(ProductManager productManager) {
        this.productManager = productManager;
    }

    @RequestMapping(value = "/product/delete", method = RequestMethod.POST)
    public ResponseEntity<String> deleteProduct(int id) {

        productManager.deleteProduct(id);
        return new ResponseEntity<String>("Produkt usunięty", HttpStatus.OK);
    }

    @RequestMapping(value = "/product/find", method = RequestMethod.GET)
    public ResponseEntity<Product> findProduct(int id) {
        return new ResponseEntity<Product>(productManager.findProduct(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/get-all", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<List<Product>>(productManager.getAllProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public ResponseEntity<Product> AddProduct(int modelId, Size size) {
        return new ResponseEntity<Product>(productManager.AddProduct(modelId, size), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/add-with-model", method = RequestMethod.POST)
    public ResponseEntity<Product> AddProduct(Model model, Size size) {
        return new ResponseEntity<Product>(productManager.AddProduct(model, size), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/find-by-model-and-size", method = RequestMethod.GET)
    public ResponseEntity<Product> findByModelAndSize(Model model, Size size) {
        return new ResponseEntity<Product>(productManager.findByModelAndSize(model, size), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/order", method = RequestMethod.POST)
    public ResponseEntity<MissingProductException> orderProducts(int orderId, List<Product> products) {
        try {
            productManager.orderProducts(orderId, products);
        } catch (MissingProductException e) {
            return new ResponseEntity<MissingProductException>(e, HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<MissingProductException>(
                new MissingProductException(new LinkedList<>()), HttpStatus.OK);
    }
}
