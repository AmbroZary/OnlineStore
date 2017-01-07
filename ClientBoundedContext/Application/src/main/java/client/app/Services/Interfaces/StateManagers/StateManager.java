package client.app.Services.Interfaces.StateManagers;

import client.domain.Aggregates.OrderAggregate.OrderState;

public interface StateManager {
    void changeOrderState(int id, OrderState state);
}
