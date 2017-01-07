package finances.infrastructure.Repositories;


import client.domain.Aggregates.OrderAggregate.Order;
import common.HibernateUtil;
import finances.domain.AccountAggregate.Account;
import finances.domain.AccountAggregate.Repository.AccountRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountDBRepository extends AccountRepository{
    @Override
    public void addBalance(double amount) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        account.addToBalance(amount);
        session.update(account);

        session.getTransaction().commit();
        sessionFactory.close();
    }

    @Override
    protected Account findAccount() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Account account = (Account)session.get(Account.class, 1);

        session.getTransaction().commit();
        sessionFactory.close();

        return account;
    }

    @Override
    protected Account createAccount() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Account account = new Account(1);
        session.save(account);

        session.getTransaction().commit();
        sessionFactory.close();

        return account;
    }
}
