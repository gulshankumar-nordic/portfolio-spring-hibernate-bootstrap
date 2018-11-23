package fi.netwink.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="User")
public class User {

    /*@OneToMany(mappedBy = "user",
    cascade = {CascadeType.PERSIST, CascadeType.MERGE,
    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    //@NotEmpty(message = "Please enter your name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
