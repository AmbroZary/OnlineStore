package client.infrastructure.Factories;

import client.domain.Aggregates.UserAggregate.Cart;
import client.domain.Aggregates.UserAggregate.Client;
import client.domain.Aggregates.UserAggregate.ClientAddress;
import client.domain.Aggregates.UserAggregate.Factory.UserFactory;
import client.domain.Aggregates.UserAggregate.Repository.UserRepository;
import client.domain.Aggregates.UserAggregate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDBFactory extends UserFactory {

    private UserRepository userRepository;

    @Autowired
    public UserDBFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected User CreateUser(Cart cart, String password, ClientAddress address) {
        User user = new User(cart,password,address);
        userRepository.insert(user);
        return user;
    }

    @Override
    protected User CreateUser(String password, ClientAddress address) {
        User user = new User(password,address);
        userRepository.insert(user);
        return user;
    }
}
