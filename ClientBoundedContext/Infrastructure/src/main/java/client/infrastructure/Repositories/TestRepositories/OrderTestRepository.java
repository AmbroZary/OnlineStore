package client.infrastructure.Repositories.TestRepositories;

import common.Repositories.CommonTestRepository;
import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.Repository.OrderRepository;
import org.springframework.stereotype.Component;

@Component
public class OrderTestRepository extends CommonTestRepository<Order> implements OrderRepository{
}
