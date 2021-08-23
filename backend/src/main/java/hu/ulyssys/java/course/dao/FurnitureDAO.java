package hu.ulyssys.java.course.dao;


import hu.ulyssys.java.course.entity.Furniture;

public interface FurnitureDAO extends CoreDAO<Furniture>{
    Furniture findByUserName(String username);
}
