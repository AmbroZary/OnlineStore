package finances.domain.Services;


import client.domain.Aggregates.OrderAggregate.Order;

public interface ClientOrderRepository{

    Order getOrder(int id);

    void changeState(int id);
}
