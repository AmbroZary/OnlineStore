package client.domain.Aggregates.UserAggregate.Factory;

import client.domain.Aggregates.UserAggregate.Client;
import client.domain.Aggregates.UserAggregate.User;

/**
 * Created by Ambro on 28.12.2016.
 */
public interface UserFactory {
    Client CreateClient();
    User CreateUser(String password, String name, String lastName, String street, String houseNumber, String flatNumber, String city,
                    String postalCode, String phoneNumber, String email);
}
