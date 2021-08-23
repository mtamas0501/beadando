package hu.ulyssys.java.course.service;

import hu.ulyssys.java.course.entity.Furniture;

public interface FurnitureService extends CoreService<Furniture> {
    Furniture findByUserName(String username);
}

