package common.Repositories;

import common.HibernateUtil;
import common.Interfaces.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public abstract class CommonDBRepository<T extends Entity> implements CommonRepository<T>{

    @Override
    public void insert(T element) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        session.save(element);


        session.getTransaction().commit();
        sessionFactory.close();

    }


    @Override
    public void update(T element) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        session.update(element);


        session.getTransaction().commit();
        sessionFactory.close();
    }
}
