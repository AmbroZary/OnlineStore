package warehouse.infrastructure.Repositories;

import common.HibernateUtil;
import common.Repositories.CommonDBRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import warehouse.domain.ProductAggregate.Model;
import warehouse.domain.ProductAggregate.Repository.ModelRepository;

import java.util.List;

@Component
public class ModelDBRepository extends CommonDBRepository<Model> implements ModelRepository {
    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Query query = session.createQuery("DELETE Model WHERE id = :id ");
        query.setParameter("id", id);
        query.executeUpdate();

        session.getTransaction().commit();
        sessionFactory.close();
    }

    @Override
    public Model find(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Model model = (Model)session.get(Model.class, id);

        session.getTransaction().commit();
        sessionFactory.close();

        return model;
    }

    @Override
    public List<Model> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        List<Model> models = session.createQuery("FROM Model").list();

        session.getTransaction().commit();
        sessionFactory.close();

        return models;
    }
}
