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

    @GetMapping("/usertesting")
    public String helloWorld(){
        return "Hello user controller";
    }


    @GetMapping("/users/list")
    public List<User> getUsers(){
        return service.getUsers();
    }


    @GetMapping("/user/findById/{userId}")
    public User getUser(@PathVariable int userId, Model model){
        User user = service.getUser(userId);
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
        return "User id is :" + userId;
    }



    @RequestMapping(value = "/users/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = service.getUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        User user = service.getUser(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {

        service.saveUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
        System.out.println("Updating User " + id);

        User currentUser = service.getUser(id);

        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        currentUser.setName(user.getName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPassword(user.getPassword());

        service.saveUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUserById(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting User with id " + id);

        User user = service.getUser(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        service.deleteUser(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

}
