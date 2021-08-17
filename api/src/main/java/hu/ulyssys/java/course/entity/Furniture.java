package hu.ulyssys.java.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;

@Entity
@Table(name = "furniture")
public class Furniture extends AbstractProperty{

    @Column(name = "name",nullable = false)
    @Max(value = 200)
    private String name;
    @Column(name = "description",nullable = false)
    @Max(value = 500)
    private String description;
    @Column(name = "price",nullable = false)
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
