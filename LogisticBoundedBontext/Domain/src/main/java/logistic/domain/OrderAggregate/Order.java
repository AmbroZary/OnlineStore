package logistic.domain.OrderAggregate;

import common.Interfaces.Entity;

public class Order extends Entity{

    private Address address;
    private Boolean provided;

    public Order(int id, Address address) {
        super(id);
        this.address = address;
        this.provided = false;
    }

    public Order() {
    }

    public Address getAddress() {

        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Boolean getProvided() {
        return provided;
    }

    public void setProvided(Boolean provided) {
        this.provided = provided;
    }
}
