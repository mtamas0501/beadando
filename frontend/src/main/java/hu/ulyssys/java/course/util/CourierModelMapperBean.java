package hu.ulyssys.java.course.util;

import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.rest.model.CourierModel;

public class CourierModelMapperBean extends CoreModelMapperBean<CourierModel, Courier> {
    @Override
    public CourierModel initNewModel() {
        return new CourierModel();
    }

    @Override
    public CourierModel createModelFromEntity(Courier entity) {
        CourierModel furnitureModel = super.createModelFromEntity(entity);
        furnitureModel.setFirstName(entity.getFirstName());
        furnitureModel.setLastName(entity.getLastName());
        furnitureModel.setPhoneNumber(entity.getPhoneNumber());
        return furnitureModel;
    }

    @Override
    public void populateEntityFromModel(Courier entity, CourierModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setPhoneNumber(model.getPhoneNumber());
    }
}