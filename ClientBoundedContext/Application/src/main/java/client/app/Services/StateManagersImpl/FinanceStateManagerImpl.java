package client.app.Services.StateManagersImpl;

import client.domain.Aggregates.OrderAggregate.OrderState;
import client.domain.Aggregates.OrderAggregate.Repository.OrderRepository;
import client.app.Services.Interfaces.StateManagers.FinanceStateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinanceStateManagerImpl extends StateManagerImpl implements FinanceStateManager {

    @Autowired
    public FinanceStateManagerImpl(OrderRepository orderRepository) {
        super(orderRepository);
    }

    @Override
    public void changeOrderStateToPaid(int id)  throws NullPointerException{
        changeOrderState(id, OrderState.Paid);
    }
}
