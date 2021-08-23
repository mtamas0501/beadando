package hu.ulyssys.java.course.mbean;

import hu.ulyssys.java.course.entity.AbstractProperty;
import hu.ulyssys.java.course.entity.AppUser;
import hu.ulyssys.java.course.service.AppUserService;
import hu.ulyssys.java.course.service.CoreService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

public abstract class AwareCRUDMbean<T extends AbstractProperty> extends CoreCRUDMbean<T>{
    private List<AppUser> userList;

    protected LoggedInUserBean loggedInUserBean;

    public AwareCRUDMbean(CoreService<T> service, AppUserService appUserService, LoggedInUserBean loggedInUserBean){
        super(service);
        userList = appUserService.getAll();
        this.loggedInUserBean =loggedInUserBean;
    }

    @Override
    public void save() {
        try {
            selectedEntity.setModifiedDate(getCurrentDate());
            selectedEntity.setModifiedBy(userList.stream().filter(u -> u.getUserName().equals(loggedInUserBean.getModel().getUsername())).findFirst().get());
            super.save();
        }catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba történt mentés közben", ""));
            e.printStackTrace();
        }
    }

    @Override
    protected void saveNewEntity(){
        selectedEntity.setCreatedBy(userList.stream().filter(u -> u.getUserName().equals(loggedInUserBean.getModel().getUsername())).findFirst().get());
        super.saveNewEntity();
    }

    public List<AppUser> getUserList() {
        return userList;
    }

    public void setUserList(List<AppUser> userList) {
        this.userList = userList;
    }
}