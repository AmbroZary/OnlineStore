package logistic.domain.Services;

import client.domain.Aggregates.OrderAggregate.Order;

public interface ClientOrderRepository {

    Order getOrder(int id);
    void changeStateToSent(int id);
    void changeStateToProvided(int id);
}
