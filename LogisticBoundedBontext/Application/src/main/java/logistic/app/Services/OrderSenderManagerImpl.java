package logistic.app.Services;


import logistic.app.Services.Interfaces.OrderSenderManager;
import logistic.domain.OrderAggregate.Factory.OrderFactory;
import logistic.domain.OrderAggregate.Order;
import logistic.domain.OrderAggregate.Repository.OrderRepository;
import logistic.domain.Services.OrderSender;
import logistic.domain.Services.ClientOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSenderManagerImpl implements OrderSenderManager{

    private ClientOrderRepository clientOrderRepository;
    private OrderRepository orderRepository;
    private OrderFactory orderFactory;
    private OrderSender orderSender;

    @Autowired
    public OrderSenderManagerImpl(ClientOrderRepository clientOrderRepository, OrderRepository orderRepository, OrderFactory orderFactory, OrderSender orderSender) {
        this.clientOrderRepository = clientOrderRepository;
        this.orderRepository = orderRepository;
        this.orderFactory = orderFactory;
        this.orderSender = orderSender;
    }

    @Override
    public void sendOrder(int id) {
        Order order = orderFactory.createOrder(clientOrderRepository.getOrder(id));
        orderRepository.insert(order);
        orderSender.sendOrder(order);
    }
}
