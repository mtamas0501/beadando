package hu.ulyssys.java.course.rest;

import hu.ulyssys.java.course.entity.Furniture;
import hu.ulyssys.java.course.rest.model.FurnitureModel;
import hu.ulyssys.java.course.util.FurnitureModelMapperBean;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/furniture")
public class FurnitureRestService extends CoreRestService<Furniture, FurnitureModel> {

    @Inject
    private FurnitureModelMapperBean furnitureModelMapperBean;

    @Override
    protected void populateEntityFromModel(Furniture entity, FurnitureModel model) {
        furnitureModelMapperBean.populateEntityFromModel(entity, model);
    }

    @Override
    protected FurnitureModel createModelFromEntity(Furniture entity) {
        return furnitureModelMapperBean.createModelFromEntity(entity);
    }

    @Override
    protected Furniture initNewEntity() {
        return new Furniture();
    }

}