package client.domain.Aggregates.OrderAggregate;

import client.domain.Interfaces.Address;

public class OrderAddress extends Address {
    public OrderAddress(String name, String lastName, String street, String houseNumber, String flatNumber, String city,
                        String postalCode, String phoneNumber, String email) {
        super(name, lastName, street, houseNumber, flatNumber, city, postalCode, phoneNumber, email);
    }

}
