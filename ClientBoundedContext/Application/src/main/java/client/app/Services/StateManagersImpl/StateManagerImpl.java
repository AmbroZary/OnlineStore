package client.app.Services.StateManagersImpl;

import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.OrderStates.OrderState;
import client.domain.Aggregates.OrderAggregate.Repository.OrderRepository;
import client.app.Services.Interfaces.StateManagers.StateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateManagerImpl implements StateManager {

    private OrderRepository orderRepository;

    @Autowired
    public StateManagerImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void changeOrderState (int id, OrderState state) throws NullPointerException {
        Order order = orderRepository.find(id);
        if (order == null){
            throw new NullPointerException("Zamówienie o podanym id nie istnieje");
        }
        order.setState(state);
    }
}
