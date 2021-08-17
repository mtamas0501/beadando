package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.AbstractProperty;
import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.service.CoreService;
import hu.ulyssys.java.course.service.CourierService;

import java.util.List;

public abstract class CourierAwareCRUDMbean<T extends AbstractProperty> extends CoreCRUDMbean<T> {
    private List<Courier> courierList;

    public CourierAwareCRUDMbean(CoreService<T> service, CourierService courierService) {
        super(service);
        courierList = courierService.getAll();
    }


    public List<Courier> getFarmerList() {
        return courierList;
    }

    public void setFarmerList(List<Courier> courierList) {
        this.courierList = courierList;
    }
}