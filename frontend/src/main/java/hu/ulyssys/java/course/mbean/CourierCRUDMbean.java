package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.service.CourierService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CourierCRUDMbean extends CoreCRUDMbean<Courier> implements Serializable {


    @Inject
    public CourierCRUDMbean(CourierService courierService) {
        super(courierService);
    }

    @Override
    protected String dialogName() {
        return "courierDialog";
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}
