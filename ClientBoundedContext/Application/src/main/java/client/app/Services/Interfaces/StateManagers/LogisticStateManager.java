package client.app.Services.Interfaces.StateManagers;

public interface LogisticStateManager extends StateManager {
    void changeOrderStateToSent(int id) throws NullPointerException;
    void changeOrderStateToProvided(int id) throws NullPointerException;
}
