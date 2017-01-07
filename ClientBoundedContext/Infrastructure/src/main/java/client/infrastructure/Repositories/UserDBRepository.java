package client.infrastructure.Repositories;

import client.domain.Aggregates.OrderAggregate.Order;
import client.domain.Aggregates.UserAggregate.Cart;
import client.domain.Aggregates.UserAggregate.Repository.UserRepository;
import client.domain.Aggregates.UserAggregate.User;
import common.HibernateUtil;
import common.Repositories.CommonDBRepository;
import common.Repositories.CommonTestRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import warehouse.domain.ProductAggregate.AdditionalModelInfo;
import warehouse.domain.ProductAggregate.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class UserDBRepository extends CommonDBRepository<User> implements UserRepository{
    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Query query = session.createQuery("DELETE User WHERE id = :id ");
        query.setParameter("id", id);
        query.executeUpdate();

        session.getTransaction().commit();
        sessionFactory.close();
    }

    @Override
    public User find(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        User user = (User)session.get(Order.class, id);
        Query query = session.createSQLQuery("SELECT * FROM CLIENT.USERSPRODUCTS WHERE USERID = :id");
        query.setParameter("id", id);
        user.setCart(new Cart(new HashSet<Product>(query.list())));

        session.getTransaction().commit();
        sessionFactory.close();

        return user;
    }

    @Override
    public List<User> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        List<User> users = session.createQuery("FROM User").list();

        session.getTransaction().commit();
        sessionFactory.close();

        return users;
    }

    @Override
    public void addToCart(User user, List<Product> products) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();
        for (Product p:products) {
            user.getCart().getProducts().add(p);
            Query query = session.createSQLQuery("INSERT INTO CLIENT.USERSPRODUCTS VALUES (:userId, :productId)");
            query.setParameter("userId", user.getId());
            query.setParameter("productId", p.getId());
            query.executeUpdate();
        }

        session.getTransaction().commit();
        sessionFactory.close();

    }

    @Override
    public User findByEmail(String email) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Query query = session.createQuery("FROM User WHERE User.address.email = :email");
        query.setParameter("email", email);

        List<User> users = query.list();
        if(users.isEmpty())
            return null;

        session.getTransaction().commit();
        sessionFactory.close();

        return users.get(0);
    }
}
