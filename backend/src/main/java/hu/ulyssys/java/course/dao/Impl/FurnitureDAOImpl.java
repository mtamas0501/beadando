package hu.ulyssys.java.course.dao.Impl;

import hu.ulyssys.java.course.dao.FurnitureDAO;
import hu.ulyssys.java.course.entity.Furniture;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class FurnitureDAOImpl extends CoreDAOImpl<Furniture> implements FurnitureDAO {
    @Override
    protected Class<Furniture> getManagedClass() {
        return Furniture.class;
    }

    @Override
    public Furniture findByUserName(String username) {
        TypedQuery<Furniture> query = entityManager.createNamedQuery(Furniture.FIND_BY_USERNAME, Furniture.class);
        query.setParameter("name", username);
        List<Furniture> furnitureList = query.getResultList();
        if(furnitureList.isEmpty()){
            return null;
        }
        return furnitureList.get(0);
    }
}
