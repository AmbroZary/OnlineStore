package client.app.Services;


import warehouse.domain.ProductAggregate.Model;
import warehouse.domain.ProductAggregate.Product;
import warehouse.domain.ProductAggregate.Repository.ProductRepository;
import client.domain.Aggregates.UserAggregate.Repository.UserRepository;
import client.domain.Aggregates.UserAggregate.User;


import client.app.Services.Interfaces.CartManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import warehouse.domain.ProductAggregate.Size;

import java.util.LinkedList;
import java.util.List;

@Component
public class CartManagerImpl implements CartManager{

    @Autowired
    public CartManagerImpl(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Override
    public void removeProductFromCart(User user, int id) {
        if(user != null) {
            user.getCart().RemoveFromCard(productRepository.find(id));
            userRepository.update(user);
        }
    }

    @Override
    public void addProductToCart(User user, Model model, Size size, int quantity) throws NullPointerException {
        List<Product> products = new LinkedList<>();
        Product product;
        for(int i=0;i<quantity; i++){
            product = productRepository.findByModelAndSize(model, size);
            if(product == null)
                throw new NullPointerException("Brak produktu w magazynie");
            products.add(product);
        }
        userRepository.addToCart(user, products);
    }
}
