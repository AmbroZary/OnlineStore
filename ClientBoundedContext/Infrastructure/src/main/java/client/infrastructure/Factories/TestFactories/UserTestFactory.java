package client.infrastructure.Factories.TestFactories;


import client.domain.Aggregates.UserAggregate.Cart;
import client.domain.Aggregates.UserAggregate.Client;
import client.domain.Aggregates.UserAggregate.ClientAddress;
import client.domain.Aggregates.UserAggregate.Factory.UserFactory;
import client.domain.Aggregates.UserAggregate.Repository.UserRepository;
import client.domain.Aggregates.UserAggregate.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// @Component
public class UserTestFactory extends UserFactory{

    private int idCounter;
    private UserRepository userRepository;

    // @Autowired
    public UserTestFactory(UserRepository userRepository) {
        this.idCounter = 0;
        this.userRepository = userRepository;
    }

    @Override
    public Client CreateClient() {
        return new Client(idCounter++, new Cart());
    }

    @Override
    protected User CreateUser(Cart cart, String password, ClientAddress address) {
        User user = new User(this.idCounter++,cart,password,address);
        userRepository.insert(user);
        return user;
    }

    @Override
    protected User CreateUser(String password, ClientAddress address) {
        User user = new User(this.idCounter++,password,address);
        userRepository.insert(user);
        return user;
    }
}
