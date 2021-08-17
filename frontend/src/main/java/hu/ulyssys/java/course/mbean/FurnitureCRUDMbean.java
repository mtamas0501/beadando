package hu.ulyssys.java.course.mbean;


import hu.ulyssys.java.course.entity.Furniture;
import hu.ulyssys.java.course.entity.Order;
import hu.ulyssys.java.course.service.CoreService;
import hu.ulyssys.java.course.service.CourierService;
import hu.ulyssys.java.course.service.FurnitureService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class FurnitureCRUDMbean extends CoreCRUDMbean<Furniture> implements Serializable {


    @Inject
    public FurnitureCRUDMbean(FurnitureService furnitureService) {
        super(furnitureService);
    }


    @Override
    protected String dialogName() {
        return "furnitureDialog";
    }

    @Override
    protected Furniture initNewEntity() {
        return new Furniture();
    }
}
