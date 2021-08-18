package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.service.CourierService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class CourierCRUDMbean extends CoreCRUDMbean<Courier> implements Serializable {


    @Inject
    public CourierCRUDMbean(CourierService courierService) {
        super(courierService);
    }

    @Override
    protected String dialogName() {
        return "courierDialog";
    }

    @Override
    public void save() {
        try {
            if (getSelectedEntity().getId() == null) {
                getSelectedEntity().setCreatedDate(new Date());
            } else {
                getSelectedEntity().setModifiedDate(new Date());
            }
            super.save();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba történt hashelés közben", ""));
            e.printStackTrace();
        }
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}
