package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.Order;
import hu.ulyssys.java.course.service.CoreService;
import hu.ulyssys.java.course.service.CourierService;
import hu.ulyssys.java.course.service.OrderService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

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
    protected Order initNewEntity() {
        return new Order();
    }
}
