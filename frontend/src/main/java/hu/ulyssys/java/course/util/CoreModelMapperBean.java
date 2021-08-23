package hu.ulyssys.java.course.util;

import hu.ulyssys.java.course.entity.AbstractProperty;
import hu.ulyssys.java.course.entity.AppUserRole;
import hu.ulyssys.java.course.rest.model.CoreRestModel;
import hu.ulyssys.java.course.service.AppUserService;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CoreModelMapperBean<M extends CoreRestModel, T extends AbstractProperty> {

    @Inject
    private AppUserService appUserService;

    public M createModelFromEntity(T entity) {
        M model = initNewModel();
        model.setId(entity.getId());
        model.setCreatedDate(entity.getCreatedDate());
        model.setModifiedDate(entity.getModifiedDate());
        if (entity.getCreatedBy() != null){
            model.setCreatedById(entity.getCreatedBy().getId());
        }
        if (entity.getModifiedBy() != null){
            model.setModifiedById(entity.getModifiedBy().getId());
        }
        return model;
    }

    public List<M> createModelsFromList(List<T> entity) {
        return entity.stream().map(this::createModelFromEntity).collect(Collectors.toList());
    }

    public void populateEntityFromModel(T entity, M model) {
        entity.setModifiedDate(new Date(System.currentTimeMillis()));
        entity.setModifiedBy(appUserService.getAll().stream().filter(appUser -> appUser.getRole().equals(AppUserRole.valueOf("ADMIN"))).collect(Collectors.toList()).get(0));
    }

    public abstract M initNewModel();

}