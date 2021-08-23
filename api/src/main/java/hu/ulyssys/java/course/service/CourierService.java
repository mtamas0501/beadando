package hu.ulyssys.java.course.service;

import hu.ulyssys.java.course.entity.Courier;

public interface CourierService extends CoreService<Courier> {
    Courier findByUserName(String firstName, String lastName);
}
