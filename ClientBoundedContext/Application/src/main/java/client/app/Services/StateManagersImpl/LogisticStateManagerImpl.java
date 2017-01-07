package client.app.Services.StateManagersImpl;

import client.domain.Aggregates.OrderAggregate.OrderState;
import client.domain.Aggregates.OrderAggregate.Repository.OrderRepository;
import client.app.Services.Interfaces.StateManagers.LogisticStateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogisticStateManagerImpl extends StateManagerImpl implements LogisticStateManager {

    @Autowired
    public LogisticStateManagerImpl(OrderRepository orderRepository) {
        super(orderRepository);
    }

    @Override
    public void changeOrderStateToSent(int id)  throws NullPointerException{
        changeOrderState(id, OrderState.Sent);
    }

    @Override
    public void changeOrderStateToProvided(int id) throws NullPointerException {
        changeOrderState(id, OrderState.Provided);
    }
}
