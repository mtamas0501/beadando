package hu.ulyssys.java.course.converter;

import hu.ulyssys.java.course.entity.Furniture;
import hu.ulyssys.java.course.service.FurnitureService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class FurnitureConverter implements Converter {

    @Inject
    private FurnitureService furnitureService;


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        return furnitureService.findByName(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Furniture) {
            return ((Furniture) o).getName();
        }
        if (o instanceof String) {
            return o.toString();
        }
        return null;
    }
}
