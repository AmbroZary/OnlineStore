package client.infrastructure.Repositories;

import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.OrderAggregate.OrderState;
import client.domain.Aggregates.OrderAggregate.Repository.OrderRepository;
import common.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import warehouse.domain.ProductAggregate.Product;
import warehouse.domain.ProductAggregate.Repository.MissingProductException;

import java.util.ArrayList;
import java.util.List;

public class OrderDBRepository implements OrderRepository {

    private ProductWarehouseRepository productWarehouseRepository;

    @Override
    public void insert(Order order) throws MissingProductException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        productWarehouseRepository.orderProducts(order.getId(),new ArrayList<Product>(order.getProducts()));
        session.save(order);

        session.getTransaction().commit();
        sessionFactory.close();
    }

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Query query = session.createQuery("DELETE Order WHERE id = :id ");
        query.setParameter("id", id);
        query.executeUpdate();

        session.getTransaction().commit();
        sessionFactory.close();
    }
    @Override
    public Order find(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Order order = (Order)session.get(Order.class, id);
        //TODO find products for this orders, we need implement this feature in ProductWarehouseRepository

        session.getTransaction().commit();
        sessionFactory.close();

        return order;
    }

    @Override
    public List<Order> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        List<Order> orders = session.createQuery("FROM Order").list();

        session.getTransaction().commit();
        sessionFactory.close();

        return orders;
    }

    @Override
    public void update(Order order) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        for (Product p:order.getProducts()) {
            productWarehouseRepository.update(p);
        }
        session.save(order);

        session.getTransaction().commit();
        sessionFactory.close();
    }

    @Override
    public void changeOrderState(int id, OrderState state) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Query query = session.createQuery("UPDATE Order SET Order.state = :state WHERE id = :id");
        query.setParameter("id", id);
        query.setParameter("state", state);
        query.executeUpdate();

        session.getTransaction().commit();
        sessionFactory.close();
    }
}
