package logistic.infrastructure.Repositories;

import common.HibernateUtil;
import common.Repositories.CommonDBRepository;
import logistic.domain.OrderAggregate.Order;
import logistic.domain.OrderAggregate.Repository.OrderRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import warehouse.domain.ProductAggregate.Product;

import java.util.List;


@Component
public class OrderDBRepository extends CommonDBRepository<Order> implements OrderRepository {

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
    public void changeOrderIsProvided(Order order, boolean provided) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        order.setProvided(provided);
        session.save(order);

        session.getTransaction().commit();
        sessionFactory.close();
    }
}
