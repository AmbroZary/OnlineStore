package finances.infrastructure.Repositories;

import client.domain.Aggregates.OrderAggregate.Order;
import common.HibernateUtil;
import common.Repositories.CommonDBRepository;
import finances.domain.TransactionAggregate.Repository.TransactionRepository;
import finances.domain.TransactionAggregate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionDBRepository extends CommonDBRepository<Transaction> implements TransactionRepository{

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Query query = session.createQuery("DELETE Transaction WHERE id = :id ");
        query.setParameter("id", id);
        query.executeUpdate();

        session.getTransaction().commit();
        sessionFactory.close();
    }

    @Override
    public Transaction find(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Transaction transaction = (Transaction) session.get(Transaction.class, id);

        session.getTransaction().commit();
        sessionFactory.close();

        return transaction;    }

    @Override
    public List<Transaction> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        List<Transaction> transactions = session.createQuery("FROM Transaction ").list();

        session.getTransaction().commit();
        sessionFactory.close();

        return transactions;
    }
}
