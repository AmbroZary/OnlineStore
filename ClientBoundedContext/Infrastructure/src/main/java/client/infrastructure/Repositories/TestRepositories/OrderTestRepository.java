package client.infrastructure.Repositories.TestRepositories;

import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.OrderState;
import client.domain.Aggregates.OrderAggregate.Repository.OrderRepository;
import common.Repositories.CommonTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import warehouse.domain.ProductAggregate.Product;
import warehouse.domain.ProductAggregate.Repository.MissingProductException;
import warehouse.domain.ProductAggregate.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderTestRepository implements OrderRepository{

    private CommonTestRepository<Order> orderCommonRepository;
    private ProductRepository productRepository;

    @Autowired
    public OrderTestRepository(ProductRepository productRepository) {
        this.orderCommonRepository = new CommonTestRepository<Order>();
        this.productRepository = productRepository;
    }

    @Override
    public void insert(Order order) throws MissingProductException {
        orderCommonRepository.insert(order);
        productRepository.orderProducts(order.getId(), new ArrayList<Product>(order.getProducts()));
    }

    @Override
    public void delete(int id) {
        orderCommonRepository.delete(id);
    }

    @Override
    public Order find(int id) {
        return orderCommonRepository.find(id);
    }

    @Override
    public List<Order> findAll() {
        return orderCommonRepository.findAll();
    }

    @Override
    public void update(Order element) {
        orderCommonRepository.update(element);
    }

    @Override
    public void changeOrderState(int id, OrderState state) {
        Order order = find(id);
        order.setState(state);
        update(order);
    }
}
