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
            AppUser appUser = userService.findByUsername(model.getUsername());
            if (appUser == null) {
                throw new SecurityException("Nem létező felhasználó");
            }
            String hashedPassword = DigestUtils.sha512Hex(model.getPassword());
            if (!hashedPassword.equals(appUser.getPasswordHash())) {
                throw new SecurityException("Nem megfelelő jelszó");

            }
            LoggedInUserModel loggedInUserModel = new LoggedInUserModel();
            loggedInUserModel.setUsername(appUser.getUsername());
            loggedInUserModel.setId(appUser.getId());
            loggedInUserModel.setRole(appUser.getRole());
            //loggedInUserModel.setCreatedDate(new Date());
            loggedInUserModel.setCreatedDate(appUser.getCreatedDate());
            bean.setModel(loggedInUserModel);
            PrimeFaces.current().executeScript("PF('loginDialog').hide()");
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "sikertelen bejelentkezés", ""));
        }
    }

    public void doLogout() {
        bean.setModel(null);
    }

    public LoginModel getModel() {
        return model;
    }

    public void setModel(LoginModel model) {
        this.model = model;
    }
}
