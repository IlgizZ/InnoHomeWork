package ru.kpfu.itis.model;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "item_name", nullable = false, length = 100, unique = true)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false, updatable = false)
    private Category category;

    @Column(name = "item_description", length = 300)
    private String description;

    @Column(name = "item_price", nullable = false)
    private Double price;

    @Column(name = "item_count", nullable = false)
    private Integer count;

    @Column(name = "item_photo")
    private String photo;

    @Column(name = "item_new")
    private Integer recom;

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getRecom() {
        return recom;
    }

    public void setRecom(Integer recom) {
        this.recom = recom;
    }
}
