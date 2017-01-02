package finances.domain.TransactionAggregate;

import common.Interfaces.Entity;

public class Order extends Entity {

    private double price;

    public Order(int id, double price) {
        super(id);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
