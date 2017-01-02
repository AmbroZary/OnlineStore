package logistic.domain.OrderAggregate.Repository;

import common.Repositories.CommonRepository;
import logistic.domain.OrderAggregate.Order;

public interface OrderRepository extends CommonRepository<Order>{

    void changeOrderIsProvided(Order order, boolean provided);
}
