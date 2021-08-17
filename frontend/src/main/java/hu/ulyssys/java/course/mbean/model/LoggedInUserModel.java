package hu.ulyssys.java.course.mbean.model;

import hu.ulyssys.java.course.entity.AppUserRole;

import java.util.Date;

public class LoggedInUserModel {
    private Long id;
    private String username;
    private AppUserRole role;
    private Date createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AppUserRole getRole() {
        return role;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
