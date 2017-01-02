package finances.infrastructure.Repositories.TestRepositories;

import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.OrderStates.PaidOrderState;
import finances.domain.Services.ClientOrderRepository;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class ClientOrderTestRepository implements ClientOrderRepository {

    private LinkedList<Order> list;

    public ClientOrderTestRepository() {
        list = new LinkedList<>();
    }

    @Override
    public Order getOrder(int id) {
        return list.stream()
                .filter((Order o)-> o.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void changeState(int id) {
        getOrder(id).setState(new PaidOrderState());
    }
}
