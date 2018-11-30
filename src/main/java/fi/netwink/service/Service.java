package fi.netwink.service;

import fi.netwink.entity.Product;
import fi.netwink.entity.Review;
import fi.netwink.entity.User;

import java.util.List;

public interface Service {

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

    /**
     *  Review Dao
     */

    public List<Review> getReviewByProductId(int productId);
    public Review getReview(int reviewId);
    public void saveReview(Review review);
    public void deleteReview(int reviewId);

}
