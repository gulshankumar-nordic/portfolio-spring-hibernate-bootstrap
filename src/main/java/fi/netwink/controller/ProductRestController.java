package fi.netwink.controller;

import fi.netwink.entity.Product;
import fi.netwink.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/testing")
    public String helloWorld(){
        return "Hello world";
    }


    @GetMapping("/products/byUserId/{userId}")
    public List<Product> getProductsByUserId(@PathVariable int userId){
        return service.getProductsByUserId(userId);
    }

    @GetMapping("/products/list")
    public List<Product> getProducts(){
        return service.getProducts();
    }


    @GetMapping("/product/findById/{productId}")
    public Product getProduct(@PathVariable int productId, Model model){
        Product product= service.getProduct(productId);
        model.addAttribute("product", product);
        return product;
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


    @RequestMapping(value="/list")
    public ModelAndView listOfProduct() {
        ModelAndView modelAndView = new ModelAndView("list-of-products");

        List<Product> products = service.getProducts();
        modelAndView.addObject("products", products);

        return modelAndView;
    }

    @RequestMapping(value="/productList")
    public ModelAndView productList() {
        ModelAndView modelAndView = new ModelAndView("productList");

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

        ModelAndView modelAndView = new ModelAndView("productList");
        service.saveProduct(product);

        String message = "Product was successfully added.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }

    @RequestMapping(value="/product/delete/{productId}", method=RequestMethod.GET)
    public ModelAndView deleteProduct(@PathVariable Integer productId) {
        ModelAndView modelAndView = new ModelAndView("productList");
        service.deleteProduct(productId);
        String message = "Product was successfully deleted.";
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @RequestMapping(value="/product/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editProductPage(@PathVariable Integer productId) {
        ModelAndView modelAndView = new ModelAndView("editProduct");
        Product product= service.getProduct(productId);
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @RequestMapping(value="/product/edit/{id}", method=RequestMethod.POST)
    public ModelAndView editingProduct(@ModelAttribute Product product, @PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("home");

        service.saveProduct(product);

        String message = "Product was successfully edited.";
        modelAndView.addObject("message", message);

        return modelAndView;
    }



    @RequestMapping(value="/ajaxProductList")
    public ModelAndView ajaxProductList(@ModelAttribute Product product) {

        ModelAndView modelAndView = new ModelAndView("ajaxProductList");
        return modelAndView;
    }



}
