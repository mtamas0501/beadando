package hu.ulyssys.java.course.mbean;


import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.entity.Furniture;
import hu.ulyssys.java.course.entity.Order;
import hu.ulyssys.java.course.service.*;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class OrderCRUDMbean extends AwareCRUDMbean<Order> implements Serializable {

    private List<Courier> courierList;

    private List<Furniture> furnitureList;

    private OrderService orderService;

    @Inject
    public OrderCRUDMbean(OrderService orderService, AppUserService appUserService, LoggedInUserBean loggedInUserBean, CourierService courierService, FurnitureService furnitureService) {
        super(orderService, appUserService, loggedInUserBean);
        if (!loggedInUserBean.isLoggedIn()){
            throw new SecurityException("Kérünk jelentkezzen be az oldal használatához!");
        }
        this.courierList = courierService.getAll();
        this.furnitureList = furnitureService.getAll();
        this.orderService = orderService;
        refreshData();
    }
    @Override
    protected String dialogName() {
        return "orderDialog";
    }

    @Override
    protected Order initNewEntity() {
        return new Order();
    }

    @Override
    protected void refreshData() {
        if (!loggedInUserBean.isAdmin()) {
            setList(orderService.getAll().stream().filter(order -> order.getCreatedBy().getUserName().equals(loggedInUserBean.getModel().getUsername())).collect(Collectors.toList()));
        }else {
            setList(orderService.getAll());
        }
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
