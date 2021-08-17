package hu.ulyssys.java.course.service.impl;

import hu.ulyssys.java.course.dao.CoreDAO;
import hu.ulyssys.java.course.entity.AbstractEntity;
import hu.ulyssys.java.course.service.CoreService;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.List;

public abstract class CoreServiceImpl<T extends AbstractEntity> implements CoreService<T> {
    @Inject
    protected CoreDAO<T> dao;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<T> getAll() {
        return dao.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public T findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void add(T entity) {
        dao.save(entity);
    }

    @Override
    public void remove(T entity) {
        dao.delete(entity.getId());
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

}
