package fi.netwink.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="product")
public class Product {

    //private List<User> users;

   /* @ManyToOne
    @JoinColumn(name="user_id")
    private User user;*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    //@NotEmpty(message = "Please enter your name")
    private String name;

    @Column(name = "category")
    //@NotEmpty(message = "Please enter category i.e. sukat or scarves")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private String price;

    @Column(name = "user_id")
    private int user_id;

    public Product() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", user_id=" + user_id +
                '}';
    }


}
