package client.domain.Aggregates.OrderAggregate.Repository;

import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.OrderState;
import warehouse.domain.ProductAggregate.Repository.MissingProductException;
import warehouse.domain.ProductAggregate.Repository.ProductRepository;

import java.util.List;

public interface OrderRepository{
    void insert(Order order) throws MissingProductException;
    void delete(int id);
    Order find(int id);
    List<Order> findAll();
    void update(Order order);
    void changeOrderState(int id, OrderState state);
}
