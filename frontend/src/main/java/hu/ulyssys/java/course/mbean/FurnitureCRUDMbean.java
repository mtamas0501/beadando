package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.Furniture;
import hu.ulyssys.java.course.service.AppUserService;
import hu.ulyssys.java.course.service.FurnitureService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class FurnitureCRUDMbean extends AwareCRUDMbean<Furniture> implements Serializable {
    @Inject
    public FurnitureCRUDMbean(FurnitureService furnitureService, AppUserService appUserService, LoggedInUserBean loggedInUserBean) {
        super(furnitureService, appUserService, loggedInUserBean);
        if (!loggedInUserBean.isLoggedIn()){
            throw new SecurityException("Kérünk jelentkezzen be az oldal használatához!");
        }
    }

    @Override
    protected String dialogName() {
        return "furnitureDialog";
    }

    @Override
    protected Furniture initNewEntity() {
        return new Furniture();
    }

}
