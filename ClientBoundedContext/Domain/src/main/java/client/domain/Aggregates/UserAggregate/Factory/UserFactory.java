package client.domain.Aggregates.UserAggregate.Factory;

import client.domain.Aggregates.UserAggregate.Cart;
import client.domain.Aggregates.UserAggregate.Client;
import client.domain.Aggregates.UserAggregate.ClientAddress;
import client.domain.Aggregates.UserAggregate.User;

public abstract class UserFactory {
    public Client CreateClient(){
        return new Client();
    }

    public User CreateUser(String password, String name, String lastName, String street, String houseNumber, String flatNumber, String city,
                           String postalCode, String phoneNumber, String email) {
        return CreateUser(password, createAddress(name, lastName, street, houseNumber, flatNumber, city,
                postalCode, phoneNumber, email));
    }

    public User CreateUserFromClient(String password, String name, String lastName, String street, String houseNumber,
                                     String flatNumber, String city, String postalCode, String phoneNumber, String email,
                                     Client client) {
        return CreateUser(client.getCart(), password, createAddress(name, lastName, street, houseNumber, flatNumber, city,
                postalCode, phoneNumber, email));
    }

    protected abstract User CreateUser(Cart cart, String password, ClientAddress address);

    protected abstract User CreateUser(String password, ClientAddress address);

    private ClientAddress createAddress(String name, String lastName, String street, String houseNumber, String flatNumber, String city,
                                        String postalCode, String phoneNumber, String email) {
        return new ClientAddress(name, lastName, street, houseNumber, flatNumber, city,
                postalCode, phoneNumber, email);
    }
}
