package logistic.domain.Services;

import logistic.domain.OrderAggregate.Order;
import logistic.domain.OrderAggregate.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

    private OrderRepository orderRepository;
    private ClientOrderRepository clientOrderRepository;

    @Autowired
    public OrderSender(OrderRepository orderRepository, ClientOrderRepository clientOrderRepository) {
        this.orderRepository = orderRepository;
        this.clientOrderRepository = clientOrderRepository;
    }

    public void sendOrder(Order order){
        changeStateToSent(order);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        changeStateToProvided(order);
    }

    private void changeStateToSent(Order order){
        clientOrderRepository.changeStateToSent(order.getId());
    }

    private void changeStateToProvided(Order order){
        clientOrderRepository.changeStateToProvided(order.getId());
        orderRepository.changeOrderIsProvided(order, true);
    }
}
