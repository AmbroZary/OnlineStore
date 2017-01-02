package client.domain.Aggregates.UserAggregate.Repository;

import client.domain.Aggregates.ProductAggregate.Product;
import client.domain.Aggregates.UserAggregate.User;
import common.Repositories.CommonRepository;

import java.util.List;

public interface UserRepository extends CommonRepository<User> {

    void addToCart(User user, List<Product> products);

    User findByEmail(String email);
}
