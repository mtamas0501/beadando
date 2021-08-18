package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.Order;
import hu.ulyssys.java.course.service.CoreService;
import hu.ulyssys.java.course.service.CourierService;
import hu.ulyssys.java.course.service.OrderService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class OrderCRUDMbean extends CourierAwareCRUDMbean<Order> implements Serializable {

    @Inject
    public OrderCRUDMbean(CoreService<Order> service, CourierService courierService) {
        super(service, courierService);
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
