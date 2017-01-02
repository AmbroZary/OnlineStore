package client.app.Services.Interfaces;

import client.domain.Aggregates.UserAggregate.User;
import client.domain.Aggregates.ProductAggregate.Model;
import client.domain.Aggregates.ProductAggregate.Size;

public interface CartManager {
    void removeProductFromCart(User user, int id);
    void addProductToCart(User user, Model model, Size size, int quantity);
}
