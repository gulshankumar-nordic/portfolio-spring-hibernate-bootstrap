package fi.netwink.service;

import fi.netwink.dao.Dao;
import fi.netwink.entity.Product;
import fi.netwink.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    private Dao dao;

    private static List<User> users;

    @Transactional
    public List<Product> getProducts() {

        return dao.getProducts();
    }

    public List<Product> getProductsByUserId(int userId){
        return dao.getProductsByUserId(userId);
    }

    @Transactional
    public Product getProduct(int productId) {

        return dao.getProduct(productId);
    }

    @Transactional
    public void saveProduct(Product product){

        dao.saveProduct(product);
    }

    @Transactional
    public void deleteProduct(int productId){

        dao.deleteProduct(productId);
    }


    /**
     *  User Dao
     */

    @Transactional
    public List<User> getUsers() {
        return dao.getUsers();
    }

    @Transactional
    public User getUser(int userId) {
        return dao.getUser(userId);
    }


    @Transactional
    public void saveUser(User user){
        dao.saveUser(user);
    }

    @Transactional
    public void deleteUser(int userId){
        dao.deleteUser(userId);
    }


}
