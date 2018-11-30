package fi.netwink.controller;

import fi.netwink.entity.Product;
import fi.netwink.entity.Review;
import fi.netwink.entity.User;
import fi.netwink.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class RestApiController {

    @Autowired
    private Service service;

    /**
     *
     *  Product Rest Api
     */

    @GetMapping("/product/list")
    public List<Product> getProducts(){
        return service.getProducts();
    }


    @GetMapping("/product/findById/{productId}")
    public Product getProduct(@PathVariable int productId, Model model){
        Product product= service.getProduct(productId);
        model.addAttribute("product", product);
        return product;
    }

    @GetMapping("/products/byUserId/{userId}")
    public List<Product> getProductsByUserId(@PathVariable int userId){
        return service.getProductsByUserId(userId);
    }

    @PostMapping("/product/create")
    public Product addProduct(@RequestBody Product product){
        product.setId(0);
        service.saveProduct(product);
        return product;
    }

    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product) {
        service.saveProduct(product);
        return product;
    }

    @DeleteMapping("/product/delete/{productId}")
    public String deleteProduct(@PathVariable int productId){
        Product product = service.getProduct(productId);
        if(product == null) {
            // throw new exception
        }
        service.deleteProduct(productId);
        return "Product id - " + productId;
    }


    /**
     *
     *  User Rest Api
     */

    @GetMapping("/user/list")
    public List<User> getUsers(){
        return service.getUsers();
    }


    @GetMapping("/user/findById/{userId}")
    public User getUser(@PathVariable int userId, Model model){
        User user= service.getUser(userId);
        model.addAttribute("user", user);
        return user;
    }

    @PostMapping("/user/create")
    public User addUser(@RequestBody User user){
        user.setId(0);
        service.saveUser(user);
        return user;
    }

    @PutMapping("/user/update")
    public User updateUser(@RequestBody User user) {
        service.saveUser(user);
        return user;
    }

    @DeleteMapping("/user/delete/{userId}")
    public String deleteUser(@PathVariable int userId){
        User user = service.getUser(userId);
        if(user == null) {
            // throw new exception
        }
        service.deleteUser(userId);
        return "User id - " + userId;
    }


    /**
     *
     *  Review Rest Api
     */

    @GetMapping("/review/list")
    public List<Review> getReviews(){
        return null;
    }


    @GetMapping("/user/findById/{userId}")
    public Review getReview(@PathVariable int userId, Model model){
        Review review = service.getReview(userId);
        model.addAttribute("review", review);
        return review;
    }

    @PostMapping("/user/create")
    public Review addReview(@RequestBody Review review){
        review.setId(0);
        service.saveReview(review);
        return review;
    }

    @PutMapping("/user/update")
    public Review updateReview(@RequestBody Review review) {
        service.saveReview(review);
        return review;
    }

    @DeleteMapping("/user/delete/{reviewId}")
    public String deleteReview(@PathVariable int reviewId){
        Review review = service.getReview(reviewId);
        if(review== null) {
            // throw new exception
        }
        service.deleteReview(reviewId);
        return "Review id - " + reviewId;
    }


}
