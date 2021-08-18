package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.AbstractProperty;
import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.entity.Furniture;
import hu.ulyssys.java.course.service.CoreService;
import hu.ulyssys.java.course.service.CourierService;
import hu.ulyssys.java.course.service.FurnitureService;

import java.util.List;

public abstract class AwareCRUDMbean<T extends AbstractProperty> extends CoreCRUDMbean<T> {
    private List<Courier> courierList;
    private List<Furniture> furnitureList;

    public AwareCRUDMbean(CoreService<T> service, CourierService courierService, FurnitureService furnitureService) {
        super(service);
        courierList = courierService.getAll();
        furnitureList = furnitureService.getAll();
    }

    public List<Courier> getCourierList() {
        return courierList;
    }

    public void setCourierList(List<Courier> courierList) {
        this.courierList = courierList;
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void setFurnitureList(List<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
    }
}