package fi.netwink.controller;

import fi.netwink.entity.User;
import fi.netwink.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
//@RequestMapping("/")
public class UserRestController {
    @Autowired
    private Service service;



}
