package hu.ulyssys.java.course.rest;

import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.rest.model.CourierModel;
import hu.ulyssys.java.course.util.CourierModelMapperBean;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/courier")
public class CourierRestService extends CoreRestService<Courier, CourierModel> {
    @Inject
    private CourierModelMapperBean courierModelMapperBean;

    @Override
    protected void populateEntityFromModel(Courier entity, CourierModel model) {
        courierModelMapperBean.populateEntityFromModel(entity, model);
    }

    @Override
    protected CourierModel createModelFromEntity(Courier entity) {
        return courierModelMapperBean.createModelFromEntity(entity);
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}