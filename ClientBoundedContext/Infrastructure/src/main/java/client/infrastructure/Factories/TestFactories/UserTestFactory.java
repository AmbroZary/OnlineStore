package client.infrastructure.Factories.TestFactories;


import client.domain.Aggregates.UserAggregate.Cart;
import client.domain.Aggregates.UserAggregate.Client;
import client.domain.Aggregates.UserAggregate.ClientAddress;
import client.domain.Aggregates.UserAggregate.Factory.UserFactory;
import client.domain.Aggregates.UserAggregate.Repository.UserRepository;
import client.domain.Aggregates.UserAggregate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTestFactory implements UserFactory{

    private int idCounter;
    private UserRepository userRepository;

    @Autowired
    public UserTestFactory(UserRepository userRepository) {
        this.idCounter = 0;
        this.userRepository = userRepository;
    }

    @Override
    public Client CreateClient() {
        return new Client(idCounter++, new Cart());
    }

    @Override
    public User CreateUser(String password, String email, String name, String lastName, String street, String houseNumber, String flatNumber,
                           String city, String postalCode, String phoneNumber) {
        User user = new User(idCounter++, new Cart(), password, new ClientAddress(name,lastName,street,houseNumber,flatNumber,city,
                postalCode,phoneNumber, email));
        userRepository.insert(user);
        return user;
    }
}
