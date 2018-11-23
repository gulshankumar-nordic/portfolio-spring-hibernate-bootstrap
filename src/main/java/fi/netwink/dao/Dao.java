package fi.netwink.dao;

import fi.netwink.entity.Product;
import fi.netwink.entity.User;

import java.util.List;

public interface Dao {

    public List<Product> getProducts();
    public List<Product> getProductsByUserId(int userId);

    public Product getProduct(int productId);

    public void saveProduct(Product product);

    public void deleteProduct(int productId);

    /**
     *  User Dao
     */

    public List<User> getUsers();
    public User getUser(int userId);
    public void saveUser(User user);
    public void deleteUser(int userId);



}
