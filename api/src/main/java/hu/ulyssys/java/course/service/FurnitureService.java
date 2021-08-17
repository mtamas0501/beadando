package hu.ulyssys.java.course.service;

import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.entity.Furniture;




public interface FurnitureService extends CoreService<Furniture> {

    Furniture findByName(String name);
}
