package hu.ulyssys.java.course.rest.model;

import javax.persistence.Column;

public class CourierModel extends CoreRestModel{
    //@Max(value = 500)
    private String firstName;
    //@Max(value = 500)
    private String lastName;
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
}
