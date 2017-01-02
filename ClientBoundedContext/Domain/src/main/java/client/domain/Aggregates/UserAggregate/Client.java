package client.domain.Aggregates.UserAggregate;

import common.Interfaces.Entity;

public class Client extends Entity {

    private Cart cart;

    public Client(int id, Cart cart) {
        super(id);
        this.cart = cart;
    }

    public Client() {
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


}
