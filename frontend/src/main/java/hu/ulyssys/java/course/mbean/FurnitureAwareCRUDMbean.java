package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.AbstractProperty;
import hu.ulyssys.java.course.entity.Furniture;
import hu.ulyssys.java.course.service.CoreService;
import hu.ulyssys.java.course.service.FurnitureService;

import java.util.List;

public abstract class FurnitureAwareCRUDMbean<M extends AbstractProperty> extends CoreCRUDMbean<M> {
    private List<Furniture> furnitureList;

    public FurnitureAwareCRUDMbean(CoreService<M> service, FurnitureService furnitureService) {
        super(service);
        furnitureList = furnitureService.getAll();
    }


    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void setFurnitureList(List<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
    }
}