package logistic.domain.OrderAggregate;

import common.Interfaces.Entity;

public class Order extends Entity{

    private Address address;
    private boolean provided;

    public Order(int id, Address address) {
        super(id);
        this.address = address;
        this.provided = false;
    }

    public Address getAddress() {

        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isProvided() {
        return provided;
    }

    public void setProvided(boolean provided) {
        this.provided = provided;
    }
}
