package logistic.domain.OrderAggregate.Factory;


import logistic.domain.OrderAggregate.Order;
import logistic.domain.OrderAggregate.Repository.OrderRepository;
import logistic.domain.Services.LogisticClientTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory {
    private LogisticClientTranslator logisticClientTranslator;
    private OrderRepository orderRepository;

    @Autowired
    public OrderFactory(LogisticClientTranslator logisticClientTranslator, OrderRepository orderRepository) {
        this.logisticClientTranslator = logisticClientTranslator;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(client.domain.Aggregates.OrderAggregate.Order clientOrder) {
        Order order = logisticClientTranslator.translateFromClientToLogistic(clientOrder);
        orderRepository.insert(order);
        return order;
    }

}
