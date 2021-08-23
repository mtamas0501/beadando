package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.MenuItem;
import hu.ulyssys.java.course.service.CoreService;
import hu.ulyssys.java.course.service.CourierService;
import hu.ulyssys.java.course.service.MenuItemService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class MenuItemCRUDMbean extends CoreCRUDMbean<MenuItem> implements Serializable {


    @Inject
    public MenuItemCRUDMbean(MenuItemService menuItemService, LoggedInUserBean loggedInUserBean) {
        super(menuItemService);
        if (!loggedInUserBean.isAdmin()){
            throw new SecurityException("Nincs elég jogosúltságod!");
        }
    }


    @Override
    protected String dialogName() {
        return "menuItemDialog";
    }

    @Override
    protected MenuItem initNewEntity() {
        return new MenuItem();
    }
}
