package hu.ulyssys.java.course.service.impl;

import hu.ulyssys.java.course.dao.CourierDAO;
import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.service.CourierService;

import javax.ejb.Stateless;


@Stateless
public class CourierServiceImpl extends CoreServiceImpl<Courier> implements CourierService {

    @Override
    public Courier findByName(String name) {
        return ((CourierDAO) dao).findByName(name);
    }

}
