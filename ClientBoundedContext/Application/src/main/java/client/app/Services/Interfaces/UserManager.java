package client.app.Services.Interfaces;

import client.domain.Aggregates.UserAggregate.User;


public interface UserManager {
    void changeAddress(User user, String name, String lastName, String street, String houseNumber,
                       String flatNumber, String city, String postalCode, String phoneNumber, String email);
    void changePassword(User user, String password);
    User login(String email, String password);
    User register(String password, String name, String lastName, String street, String houseNumber, String flatNumber, String city,
                  String postalCode, String phoneNumber, String email);
}
