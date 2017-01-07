package logistic.infrastructure.Repositories.TestRepositories;

import common.Repositories.CommonTestRepository;
import logistic.domain.OrderAggregate.Order;
import logistic.domain.OrderAggregate.Repository.OrderRepository;
import org.springframework.stereotype.Component;

// @Component
public class OrderTestRepository extends CommonTestRepository<Order> implements OrderRepository {

    @Override
    public void changeOrderIsProvided(Order order, boolean provided) {
        order.setProvided(provided);
        update(order);
    }
}
