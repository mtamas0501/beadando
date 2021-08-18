package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.Furniture;
import hu.ulyssys.java.course.service.FurnitureService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class FurnitureCRUDMbean extends CoreCRUDMbean<Furniture> implements Serializable {


    @Inject
    public FurnitureCRUDMbean(FurnitureService furnitureService) {
        super(furnitureService);
    }


    @Override
    protected String dialogName() {
        return "furnitureDialog";
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
    protected Furniture initNewEntity() {
        return new Furniture();
    }
}
