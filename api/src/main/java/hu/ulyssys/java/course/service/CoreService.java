package hu.ulyssys.java.course.service;

import hu.ulyssys.java.course.entity.AbstractEntity;

import javax.ejb.Singleton;
import java.util.List;


public interface CoreService<T extends AbstractEntity> {
    List<T> getAll();

    T findById(Long id);

    void add(T entity);

    void remove(T entity);

    void update(T entity);
}
