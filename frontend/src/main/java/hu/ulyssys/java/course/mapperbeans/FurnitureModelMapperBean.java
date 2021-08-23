package hu.ulyssys.java.course.mapperbeans;

import hu.ulyssys.java.course.entity.Furniture;
import hu.ulyssys.java.course.rest.model.FurnitureModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FurnitureModelMapperBean extends CoreModelMapperBean<FurnitureModel, Furniture>{
    @Override
    public FurnitureModel initNewModel() {
        return new FurnitureModel();
    }
    @Override
    public FurnitureModel createModelFromEntity(Furniture entity) {
        FurnitureModel furnitureModel = super.createModelFromEntity(entity);
        furnitureModel.setName(entity.getName());
        furnitureModel.setDescription(entity.getDescription());
        furnitureModel.setPrice(entity.getPrice());
        return furnitureModel;
    }

    @Override
    public void populateEntityFromModel(Furniture entity, FurnitureModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setPrice(model.getPrice());
    }
}