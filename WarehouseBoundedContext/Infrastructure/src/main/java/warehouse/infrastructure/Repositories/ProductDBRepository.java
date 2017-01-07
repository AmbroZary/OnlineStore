package warehouse.infrastructure.Repositories;

import common.HibernateUtil;
import common.Repositories.CommonDBRepository;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import warehouse.domain.ProductAggregate.Model;
import warehouse.domain.ProductAggregate.Product;
import warehouse.domain.ProductAggregate.Repository.MissingProductException;
import warehouse.domain.ProductAggregate.Repository.ProductRepository;
import warehouse.domain.ProductAggregate.Size;

import java.util.LinkedList;
import java.util.List;

@Component
public class ProductDBRepository extends CommonDBRepository<Product> implements ProductRepository {
    @Override
    public void delete(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Query query = session.createQuery("DELETE Product WHERE id = :id ");
        query.setParameter("id", id);
        query.executeUpdate();

        session.getTransaction().commit();
        sessionFactory.close();
    }

    @Override
    public Product find(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Product product = (Product) session.get(Product.class, id);

        session.getTransaction().commit();
        sessionFactory.close();

        return product;
    }

    @Override
    public List<Product> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        List<Product> products = session.createQuery("FROM Product").list();

        session.getTransaction().commit();
        sessionFactory.close();

        return products;
    }

    @Override
    public Product findByModelAndSize(Model model, Size size) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        Query query = session.createQuery("FROM Product WHERE model = :model and Product.size = :size");
        query.setParameter("model", model);
        query.setParameter("size", size);

        List<Product> products = query.list();
        session.getTransaction().commit();
        sessionFactory.close();

        if (products.isEmpty()) {
            return null;
        }
        return products.get(0);
    }

    @Override
    public void orderProducts(int orderId, List<Product> products) throws MissingProductException {

        List<Product> missingProducts = new LinkedList<>();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();

        for (Product p : products) {
            Product orderedProduct = findByModelAndSize(p.getModel(), p.getSize());
            if (orderedProduct == null) {
                missingProducts.add(p);
            } else {
                Query query = session.createQuery("DELETE Product WHERE id = :id ");
                query.setParameter("id", orderedProduct.getId());
                query.executeUpdate();

                query = session.createSQLQuery("INSERT INTO OrderedProduct VALUES (:productId, :modelId, :orderId, :productSize)");
                query.setParameter("productId", orderedProduct.getId());
                query.setParameter("modelId", orderedProduct.getModel().getId());
                query.setParameter("orderId", orderId);
                query.setParameter("productSize", orderedProduct.getSize());
                query.executeUpdate();
            }
        }
        session.getTransaction().commit();
        sessionFactory.close();
    }

    @Override
    public List<Product> findForOrder(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.getTransaction().begin();


        SQLQuery query = session.createSQLQuery("SELECT FROM");
        query.addEntity(Product.class);
        List<Product> products = query.list();

        session.getTransaction().commit();
        sessionFactory.close();
        return products;
    }
}
