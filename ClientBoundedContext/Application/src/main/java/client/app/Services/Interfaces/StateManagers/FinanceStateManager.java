package client.app.Services.Interfaces.StateManagers;


public interface FinanceStateManager extends StateManager {
    void changeOrderStateToPaid(int id) throws NullPointerException;
}
