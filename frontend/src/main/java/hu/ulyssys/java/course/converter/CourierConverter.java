package hu.ulyssys.java.course.converter;

import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.service.CourierService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CourierConverter implements Converter {

    @Inject
    private CourierService courierService;


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        //SQL query lesz majd, findByName
        return courierService.findByName(s);

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Courier) {
            return ((Courier) o).getFirstName();
        }
        if (o instanceof String) {
            return o.toString();
        }
        return null;
    }
}