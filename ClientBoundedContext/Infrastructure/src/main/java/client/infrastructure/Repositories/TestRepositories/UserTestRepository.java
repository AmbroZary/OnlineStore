package client.infrastructure.Repositories.TestRepositories;

import common.Repositories.CommonTestRepository;
import client.domain.Aggregates.ProductAggregate.Product;
import client.domain.Aggregates.UserAggregate.Repository.UserRepository;
import client.domain.Aggregates.UserAggregate.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTestRepository extends CommonTestRepository<User> implements UserRepository {

    @Override
    public void addToCart(User user, List<Product> products) {
        for (Product p:products) {
            user.getCart().AddToCart(p);
        }
        this.update(user);
    }

    @Override
    public User findByEmail(String email) {
        return list.stream()
                .filter((User u) -> u.getAddress().getEmail().equals(email))
                .findFirst().orElse(null);
    }
}
