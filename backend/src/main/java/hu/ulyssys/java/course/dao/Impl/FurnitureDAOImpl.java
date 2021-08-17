package hu.ulyssys.java.course.dao.Impl;

import hu.ulyssys.java.course.dao.FurnitureDAO;
import hu.ulyssys.java.course.entity.Furniture;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class FurnitureDAOImpl extends CoreDAOImpl<Furniture> implements FurnitureDAO {


    @Override
    public Furniture findByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Furniture> criteriaQuery = criteriaBuilder.createQuery(Furniture.class);
        Root<Furniture> root = criteriaQuery.from(Furniture.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
        TypedQuery<Furniture> query = entityManager.createQuery(criteriaQuery);
        List<Furniture> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected Class<Furniture> getManagedClass() {
        return Furniture.class;
    }
}
