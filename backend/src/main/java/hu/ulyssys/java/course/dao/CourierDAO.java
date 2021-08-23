package hu.ulyssys.java.course.dao;

import hu.ulyssys.java.course.entity.Courier;

public interface CourierDAO extends CoreDAO<Courier>{
    Courier findByUserName(String firstName, String lastName);
}
