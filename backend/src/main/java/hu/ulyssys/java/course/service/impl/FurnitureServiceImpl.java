package hu.ulyssys.java.course.service.impl;

import hu.ulyssys.java.course.dao.CourierDAO;
import hu.ulyssys.java.course.dao.FurnitureDAO;
import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.entity.Furniture;
import hu.ulyssys.java.course.service.FurnitureService;

import javax.ejb.Stateless;
import java.util.Date;

@Stateless
public class FurnitureServiceImpl extends CoreServiceImpl<Furniture> implements FurnitureService {

    @Override
    public Furniture findByName(String name) {
        return ((FurnitureDAO) dao).findByName(name);
    }
}
