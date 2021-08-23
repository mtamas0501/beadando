package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.AppUser;
import hu.ulyssys.java.course.mbean.model.LoggedInUserModel;
import hu.ulyssys.java.course.mbean.model.LoginModel;
import hu.ulyssys.java.course.service.AppUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.PrimeFaces;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.Date;

@Named
@RequestScoped
public class LoginRequestBean {
    private LoginModel model = new LoginModel();

    @Inject
    private LoggedInUserBean bean;

    @Inject
    private AppUserService userService;

    public void doLogin() {

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/xhtml/order.xhtml");
            //Ha sikeres a login
            AppUser appUser = userService.findByUserName(model.getUsername());
            if (appUser == null) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hibás jelszó vagy felhasználónév", ""));
            }
            String hashedPassword = DigestUtils.sha512Hex(model.getPassword());
            if (!hashedPassword.equals(appUser.getPasswordHash())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hibás jelszó vagy felhasználónév", ""));
            }
            LoggedInUserModel loggedInUserModel = new LoggedInUserModel();
            loggedInUserModel.setUsername(appUser.getUserName());
            loggedInUserModel.setId(appUser.getId());
            loggedInUserModel.setRole(appUser.getRole());
            bean.setModel(loggedInUserModel);
            PrimeFaces.current().executeScript("PF('loginDialog').hide()");
            PrimeFaces.current().executeScript("PF('registrationDialog').hide()");
            //Akkor  sessionbe beállítjuk a usert reprezentáló modelt.
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "sikertelen bejelentkezés", ""));
        }


    }

    public void doLogout() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/xhtml/registration.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "sikertelen kijelentkezés", ""));
        }
        bean.setModel(null);
    }

    public LoginModel getModel() {
        return model;
    }

    public void setModel(LoginModel model) {
        this.model = model;
    }
}