package hu.ulyssys.java.course.rest.model;

import javax.persistence.Column;

public class FurnitureModel extends CoreRestModel{
    //@Max(value = 200)
    private String name;
    //@Max(value = 500)
    private String description;
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
