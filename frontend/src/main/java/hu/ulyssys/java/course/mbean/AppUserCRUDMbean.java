package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.AppUser;
import hu.ulyssys.java.course.service.AppUserService;
import hu.ulyssys.java.course.service.CoreService;
import hu.ulyssys.java.course.service.MenuItemService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class AppUserCRUDMbean extends CoreCRUDMbean<AppUser> implements Serializable {

    private LoggedInUserBean loggedInUserBean;

    @Inject
    public AppUserCRUDMbean(AppUserService appUserService, LoggedInUserBean loggedInUserBean) {
        super(appUserService);
        if (!loggedInUserBean.isAdmin()){
            throw new SecurityException("Nincs elég jogosúltságod!");
        }
        this.loggedInUserBean = loggedInUserBean;
    }

    @Override
    protected String dialogName() {
        return "userDialog";
    }

    @Override
    protected AppUser initNewEntity() {
        return new AppUser();
    }

    @Override
    public void save() {
        try {
            if (getSelectedEntity().getId() == null) {
                getSelectedEntity().setPasswordHash(hashPassword(getSelectedEntity().getPasswordHash()));
            }
            super.save();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba történt hashelés közben", ""));
            e.printStackTrace();
        }
    }

    @Override
    public void remove() {
        if (loggedInUserBean.getModel().getId() != selectedEntity.getId()){
            super.remove();
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nem törölheted saját magad az adatbázisból", ""));
        }
    }

    public void registration(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/xhtml/furniture.xhtml");
            save();
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba történt regisztráció közben", ""));
            e.printStackTrace();
        }
    }

    private String hashPassword(String rawPassword) {
        return DigestUtils.sha512Hex(rawPassword);
    }
}