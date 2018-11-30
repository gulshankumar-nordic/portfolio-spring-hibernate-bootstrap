package fi.netwink.controller;

import fi.netwink.entity.Product;
import fi.netwink.entity.Review;
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
public class ReviewController {

    @Autowired
    private Service service;

    @RequestMapping(value = "/product/{product_id}/reviews")
    public ModelAndView listReviewByProduct(@ModelAttribute("reviews") Review review, @PathVariable int product_id)
    {
        ModelAndView model = new ModelAndView("reviews");
        List <Review> reviewList = service.getReviewByProductId(product_id);
        System.out.println(reviewList);
        model.addObject("reviewList", reviewList);
        return model;
    }



}
