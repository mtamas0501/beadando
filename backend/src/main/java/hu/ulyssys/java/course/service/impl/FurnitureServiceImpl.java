package hu.ulyssys.java.course.service.impl;

import hu.ulyssys.java.course.dao.FurnitureDAO;
import hu.ulyssys.java.course.entity.Furniture;
import hu.ulyssys.java.course.service.FurnitureService;

import javax.ejb.Stateless;

@Stateless
public class FurnitureServiceImpl extends CoreServiceImpl<Furniture> implements FurnitureService {
    @Override
    public Furniture findByUserName(String username) {
        return ((FurnitureDAO) dao).findByUserName(username);
    }
}