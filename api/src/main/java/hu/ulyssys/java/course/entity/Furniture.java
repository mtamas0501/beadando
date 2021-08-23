package hu.ulyssys.java.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Objects;

@NamedQuery(name = Furniture.FIND_BY_USERNAME, query = "select u from Furniture u where u.name=:name ")
@Entity
@Table(name = "furniture")
public class Furniture extends AbstractProperty {

    public static  final String FIND_BY_USERNAME = "Furniture.findByUsername";

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Furniture)) return false;
        Furniture furniture = (Furniture) o;
        return price == furniture.price && Objects.equals(name, furniture.name) && Objects.equals(description, furniture.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }
}
