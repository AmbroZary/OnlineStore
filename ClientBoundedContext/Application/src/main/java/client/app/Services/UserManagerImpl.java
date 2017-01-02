package client.app.Services;

import client.domain.Aggregates.UserAggregate.ClientAddress;
import client.domain.Aggregates.UserAggregate.Factory.UserFactory;
import client.domain.Aggregates.UserAggregate.Repository.UserRepository;
import client.domain.Aggregates.UserAggregate.User;
import client.app.Services.Interfaces.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManagerImpl implements UserManager {

    private UserRepository userRepository;
    private UserFactory userFactory;

    @Autowired
    public UserManagerImpl(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    @Override
    public void changeAddress(User user, String name, String lastName, String street, String houseNumber, String flatNumber,
                              String city, String postalCode, String phoneNumber, String email) {
        user.setAddress(new ClientAddress(name,lastName,street,houseNumber,flatNumber,city,postalCode,phoneNumber,email));
        userRepository.update(user);
    }

    @Override
    public void changePassword(User user, String password) {
        user.setPassword(password);
        userRepository.update(user);
    }

    @Override
    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    @Override
    public User register(String password, String name, String lastName, String street, String houseNumber, String flatNumber, String city, String postalCode, String phoneNumber, String email) {
        return userFactory.CreateUser(password,name,lastName,street,houseNumber,flatNumber,city,postalCode,phoneNumber,email);
    }

}
