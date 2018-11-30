package fi.netwink.entity;

import javax.persistence.*;

@Entity
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="date")
    //@NotEmpty(message = ".....")
    private String date;

    @Column(name = "review")
    //@NotEmpty(message = ".....")
    private String review;

    @Column(name = "product_id")
    private int product_id;

    @Column(name = "user_id")
    private int user_id;

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", review='" + review + '\'' +
                ", product_id=" + product_id +
                ", user_id=" + user_id +
                '}';
    }
}
