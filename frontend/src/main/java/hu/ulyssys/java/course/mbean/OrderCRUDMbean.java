package hu.ulyssys.java.course.mbean;


import hu.ulyssys.java.course.entity.Furniture;
import hu.ulyssys.java.course.entity.Order;
import hu.ulyssys.java.course.service.CoreService;
import hu.ulyssys.java.course.service.CourierService;
import hu.ulyssys.java.course.service.FurnitureService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class OrderCRUDMbean extends AwareCRUDMbean<Order> implements Serializable {

    @Inject
    public OrderCRUDMbean(CoreService<Order> service, CourierService courierService, FurnitureService furnitureService) {
        super(service, courierService,furnitureService);
    }

    @Override
    protected String dialogName() {
        return "orderDialog";
    }

    @Override
    public void save() {
        try {
            if (getSelectedEntity().getId() == null) {
                getSelectedEntity().setCreatedDate(new Date());
            } else {
                getSelectedEntity().setModifiedDate(new Date());
            }
            super.save();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba történt hashelés közben", ""));
            e.printStackTrace();
        }
    }

    @Override
    protected Order initNewEntity() {
        return new Order();
    }

}
