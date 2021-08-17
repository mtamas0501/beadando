package hu.ulyssys.java.course.service;

import hu.ulyssys.java.course.entity.Courier;

import javax.ejb.Singleton;


public interface CourierService extends CoreService<Courier> {

    Courier findByName(String name);
}
