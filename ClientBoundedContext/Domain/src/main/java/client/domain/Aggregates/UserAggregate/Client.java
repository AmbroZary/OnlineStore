package client.domain.Aggregates.UserAggregate;

import common.Interfaces.Entity;

public class Client extends Entity {

    private Cart cart;

    public Client(int id, Cart cart) {
        super(id);
        this.cart = cart;
    }

    public Client(int id) {
        super(id);
        this.cart = new Cart();
    }

    public Client(Cart cart) {
        this.cart = cart;
    }

    public Client() {
        this.cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


}
