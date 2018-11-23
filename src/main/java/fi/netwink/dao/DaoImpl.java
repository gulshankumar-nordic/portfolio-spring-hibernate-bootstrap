package fi.netwink.dao;

import fi.netwink.entity.Product;
import fi.netwink.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoImpl implements Dao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    private List<Product> products;

    private List<User> users;


    public List<Product> getProducts() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Product> query = currentSession.createQuery("from Product where user_id=1", Product.class);
        List<Product> products = query.getResultList();
        return products;
    }

    public List<Product> getProductsByUserId(int userId) {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<Product> query = currentSession.createQuery("from Product where user_id=:userId", Product.class);
        List<Product> products = query.getResultList();
        return products;
    }

    public Product getProduct(int productId){
        Session currentSession  = sessionFactory.getCurrentSession();
        Product product = currentSession.get(Product.class, productId);
        return product;
    }

    public void saveProduct(Product product) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(product);
    }

    public void deleteProduct(int productId){
        Session currentSession = sessionFactory.getCurrentSession();
        Query query= currentSession.createQuery("DELETE from Product where id=:productId");
        query.setParameter("productId", productId);
        query.executeUpdate();
    }

    /**
     * for Users
     */

    public List<User> getUsers() {

        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("from User", User.class);
        List<User> users = query.getResultList();
        return users;
    }


    public User getUser(int userId){
        Session currentSession  = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, userId);
        return user;
    }

    public void saveUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }

    public void deleteUser(int userId){
        Session currentSession = sessionFactory.getCurrentSession();
        Query query= currentSession.createQuery("DELETE from Users where id=:userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }


}
