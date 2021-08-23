package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.AppUser;
import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.service.AppUserService;
import hu.ulyssys.java.course.service.CourierService;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CourierCRUDMbean extends AwareCRUDMbean<Courier> implements Serializable {
    @Inject
    public CourierCRUDMbean(CourierService courierService, AppUserService appUserService, LoggedInUserBean loggedInUserBean) {
        super(courierService, appUserService, loggedInUserBean);
        if (!loggedInUserBean.isAdmin()){
            throw new SecurityException("Nincs elég jogosúltságod!");
        }
    }

    @Override
    public void save() {
        if (!selectedEntity.getLastName().equals(selectedEntity.getFirstName())){
            super.save();
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "A keresztnév és a vezetéknév különböző kell legyen!", ""));
        }
    }

    @Override
    protected String dialogName() {
        return "courierDialog";
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}
