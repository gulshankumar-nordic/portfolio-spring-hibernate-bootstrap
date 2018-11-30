package fi.netwink.controller;

import fi.netwink.entity.Product;
import fi.netwink.entity.User;
import fi.netwink.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductRestController {

    @Autowired
    private Service service;

    //List<Product> products= service.getProducts();

    @RequestMapping(value="/productList")
    public ModelAndView productList() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Product> products = service.getProducts();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @RequestMapping(value="/product/add")
    public ModelAndView addProductPage() {
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @RequestMapping(value="/product/add/process")
    public ModelAndView processProduct(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        service.saveProduct(product);
        String message = "Product was successfully added.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    /*@RequestMapping(value="/product/delete/{productId}", method=RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable Integer productId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/productList");
        service.deleteProduct(productId);
        String message = "Product was successfully deleted.";
        modelAndView.addObject("message", message);
        List<Product> products = service.getProducts();
        modelAndView.addObject("products", products);

        return modelAndView;
    }*/

    @RequestMapping(value="/product/edit/{productId}", method=RequestMethod.GET)
    public ModelAndView editProductPage(@PathVariable int productId) {
        ModelAndView modelAndView = new ModelAndView("editProduct");
        Product product= service.getProduct(productId);
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @RequestMapping(value="/product/edit/{id}", method=RequestMethod.POST)
    public ModelAndView editingProduct(@ModelAttribute Product product, @PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        service.saveProduct(product);
        String message = "Product was successfully edited.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value="/product/view/{productId}", method=RequestMethod.GET)
    public ModelAndView viewProductPage(@PathVariable int productId) {
        ModelAndView modelAndView = new ModelAndView("viewProduct");
        Product product= service.getProduct(productId);
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @RequestMapping(value="/product/user/{userId}", method=RequestMethod.GET)
    public ModelAndView viewUserProductPage(@PathVariable int userId) {
        ModelAndView modelAndView = new ModelAndView("productListUser");
        List<Product> products = service.getProductsByUserId(userId);
        modelAndView.addObject("product",products);
        return modelAndView;
    }

    @RequestMapping(value = "/products")
    public ModelAndView listProducts(@ModelAttribute("products") Product product)
    {
        ModelAndView model = new ModelAndView("products");
        List <Product> productList = service.getProducts();
        System.out.println(productList);
        model.addObject("productList", productList);
        return model;
    }

    @RequestMapping(value = "/product",method=RequestMethod.POST)
    public ModelAndView saveProduct(@ModelAttribute("addProduct") Product product)
    {
        try
        {
            if(service.getProduct(product.getId()) != null);
            service.saveProduct(product);
        }
        catch(EmptyResultDataAccessException e)
        {
            System.out.println("inside catch");
            service.saveProduct(product);
        }
        return new ModelAndView("redirect:/products");
    }

    @RequestMapping(value = "/product/deleteById/{id}")
    public ModelAndView deleteProduct(@ModelAttribute("products") Product product, @PathVariable("id") int id)
    {
        service.deleteProduct(id);
        return new ModelAndView("redirect:/products");
    }

    @RequestMapping(value="/ajaxProductList")
    public ModelAndView ajaxProductList(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView("ajaxProductList");
        return modelAndView;
    }





}
