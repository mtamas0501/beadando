package hu.ulyssys.java.course.util;

import hu.ulyssys.java.course.entity.AbstractEntity;
import hu.ulyssys.java.course.entity.Order;
import hu.ulyssys.java.course.rest.model.OrderModel;
import hu.ulyssys.java.course.service.CourierService;
import hu.ulyssys.java.course.service.FurnitureService;

import javax.inject.Inject;
import java.util.stream.Collectors;

public class OrderModelMapperBean extends CoreModelMapperBean<OrderModel, Order> {

    @Inject
    private CourierService courierService;

    @Inject
    private FurnitureService furnitureService;

    @Override
    public OrderModel initNewModel() {
        return new OrderModel();
    }
    @Override
    public OrderModel createModelFromEntity(Order entity) {
        OrderModel furnitureModel = super.createModelFromEntity(entity);
        furnitureModel.setDeliveredDate(entity.getDeliveredDate());
        if (entity.getCourier() != null) {
            furnitureModel.setCourier(entity.getCourier().getId());
        }else {
            furnitureModel.setCourier(null);
        }
        furnitureModel.setFurnitures(entity.getFurnitures().stream().map(AbstractEntity::getId).collect(Collectors.toList()));
        furnitureModel.setSettlement(entity.getSettlement());
        furnitureModel.setPublicSpace(entity.getPublicSpace());
        furnitureModel.setNatureOfPublicSpace(entity.getNatureOfPublicSpace());
        furnitureModel.setHouseNumber(entity.getHouseNumber());
        return furnitureModel;
    }

    @Override
    public void populateEntityFromModel(Order entity, OrderModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setDeliveredDate(model.getDeliveredDate());
        if (model.getCourier() != null) {
            entity.setCourier(courierService.findById(model.getCourier()));
        }
        if (model.getFurnitures() != null) {
            entity.setFurnitures(model.getFurnitures().stream().map(furniture -> furnitureService.findById(furniture)).collect(Collectors.toList()));
        }
        entity.setSettlement(model.getSettlement());
        entity.setPublicSpace(model.getPublicSpace());
        entity.setNatureOfPublicSpace(model.getNatureOfPublicSpace());
        entity.setHouseNumber(model.getHouseNumber());
    }
}