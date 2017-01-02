package client.domain.Aggregates.UserAggregate;

import client.domain.Interfaces.Address;

public class ClientAddress extends Address{
    public ClientAddress(String name, String lastName, String street, String houseNumber, String flatNumber, String city, String postalCode,
                  String phoneNumber, String email) {
        super(name, lastName, street, houseNumber, flatNumber, city, postalCode, phoneNumber, email);
    }
}
