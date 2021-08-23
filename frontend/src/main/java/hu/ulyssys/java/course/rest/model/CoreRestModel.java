package hu.ulyssys.java.course.rest.model;

import javax.validation.constraints.*;
import java.util.Date;

public abstract class CoreRestModel {
    private Long id;

    @PastOrPresent
    private Date createdDate;

    @PastOrPresent
    private Date modifiedDate;

    private Long createdUserById;

    private Long modifiedUserById;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getCreatedUserById() {
        return createdUserById;
    }

    public void setCreatedUserById(Long createdUserById) {
        this.createdUserById = createdUserById;
    }

    public Long getModifiedUserById() {
        return modifiedUserById;
    }

    public void setModifiedUserById(Long modifiedUserById) {
        this.modifiedUserById = modifiedUserById;
    }
}