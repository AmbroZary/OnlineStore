package client.app.Services.RestServices;


import client.domain.Aggregates.UserAggregate.User;
import client.app.Services.CartManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import warehouse.domain.ProductAggregate.Model;
import warehouse.domain.ProductAggregate.Size;

@RestController
public class CartManagerRestAPI {

    private CartManagerImpl cartManager;

    @Autowired
    public CartManagerRestAPI(CartManagerImpl cartManager) {
        this.cartManager = cartManager;
    }

    @RequestMapping(value = "/cart/add", method = RequestMethod.POST)
    public ResponseEntity<String> addProductToCart(User user, Model model, Size size, int quantity){
        try{
            cartManager.addProductToCart(user,model,size,quantity);
        }
        catch (NullPointerException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("Produkt dodany do koszyka", HttpStatus.OK);
    }

    @RequestMapping(value = "/cart/remove", method = RequestMethod.POST)
    public ResponseEntity<String> removeProductFromCard(User user, int id){
        cartManager.removeProductFromCart(user, id);
        return new ResponseEntity<String>("git", HttpStatus.OK);
    }
}
