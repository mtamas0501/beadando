package hu.ulyssys.java.course.mapperbeans;

import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.rest.model.CourierModel;

public class CourierModelMapperBean extends CoreModelMapperBean<CourierModel, Courier> {
    @Override
    public CourierModel initNewModel() {
        return new CourierModel();
    }

    @Override
    public CourierModel createModelFromEntity(Courier entity) {
        CourierModel courierModel = super.createModelFromEntity(entity);
        courierModel.setFirstName(entity.getFirstName());
        courierModel.setLastName(entity.getLastName());
        courierModel.setPhoneNumber(entity.getPhoneNumber());
        return courierModel;
    }

    @Override
    public void populateEntityFromModel(Courier entity, CourierModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setPhoneNumber(model.getPhoneNumber());
    }
}