package hu.ulyssys.java.course.mapperbeans;

import hu.ulyssys.java.course.entity.AbstractProperty;
import hu.ulyssys.java.course.entity.AppUserRole;
import hu.ulyssys.java.course.rest.model.CoreRestModel;
import hu.ulyssys.java.course.service.AppUserService;

import javax.inject.Inject;
import java.util.Date;
import java.util.stream.Collectors;

public abstract class CoreModelMapperBean<M extends CoreRestModel, T extends AbstractProperty> {

    @Inject
    private AppUserService appUserService;

    public M createModelFromEntity(T entity) {
        M model = initNewModel();
        model.setId(entity.getId());
        model.setCreatedDate(entity.getCreatedDate());
        model.setModifiedDate(entity.getModifiedDate());
        if (entity.getCreatedUser() != null){
            model.setCreatedUserById(entity.getCreatedUser().getId());
        }
        if (entity.getModifiedUser() != null){
            model.setModifiedUserById(entity.getModifiedUser().getId());
        }
        return model;
    }

    public void populateEntityFromModel(T entity, M model) {
        entity.setModifiedDate(new Date(System.currentTimeMillis()));
        entity.setModifiedUser(appUserService.getAll().stream().filter(appUser -> appUser.getRole().equals(AppUserRole.valueOf("ADMIN"))).collect(Collectors.toList()).get(0));
    }

    public abstract M initNewModel();

}