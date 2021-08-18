package hu.ulyssys.java.course.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import java.util.Objects;

@Entity
@Table(name = "courier")
public class Courier extends AbstractProperty {

    @Column(name = "first_name",nullable = false)
    @Max(value = 500)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    @Max(value = 500)
    private String lastName;
    @Column(name = "telephone_number",nullable = false)
    private Integer telephoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(Integer telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courier courier = (Courier) o;
        return Objects.equals(firstName, courier.firstName) && Objects.equals(lastName, courier.lastName) && Objects.equals(telephoneNumber, courier.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, telephoneNumber);
    }
}
