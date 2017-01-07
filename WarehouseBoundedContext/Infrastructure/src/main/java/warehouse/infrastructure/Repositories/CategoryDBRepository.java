package warehouse.infrastructure.Repositories;


import common.HibernateUtil;
import common.Repositories.CommonDBRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import warehouse.domain.ProductAggregate.Category;
import warehouse.domain.ProductAggregate.Repository.CategoryRepository;

import java.util.List;

@Component
public class CategoryDBRepository extends CommonDBRepository<Category> implements CategoryRepository{

    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Query query = session.createQuery("DELETE Category WHERE id = :id ");
        query.setParameter("id", id);
        query.executeUpdate();

        session.getTransaction().commit();
        sessionFactory.close();
    }

    @Override
    public Category find(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Category category = (Category)session.get(Category.class, id);

        session.getTransaction().commit();
        sessionFactory.close();

        return category;
    }

    @Override
    public List<Category> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        List<Category> categories = session.createQuery("FROM Category").list();

        session.getTransaction().commit();
        sessionFactory.close();

        return categories;
    }
}
