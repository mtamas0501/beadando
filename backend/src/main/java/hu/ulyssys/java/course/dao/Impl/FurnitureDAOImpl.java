package hu.ulyssys.java.course.dao.Impl;

import hu.ulyssys.java.course.dao.FurnitureDAO;
import hu.ulyssys.java.course.entity.Furniture;

import javax.ejb.Stateless;

@Stateless
public class FurnitureDAOImpl extends CoreDAOImpl<Furniture> implements FurnitureDAO {

    @Override
    protected Class<Furniture> getManagedClass() {
        return Furniture.class;
    }
}
