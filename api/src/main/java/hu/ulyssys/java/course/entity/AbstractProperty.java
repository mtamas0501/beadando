package hu.ulyssys.java.course.entity;


import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractProperty extends AbstractEntity{


    @Column(name = "created_date",nullable = false)
    private Date createdDate;
    @Column(name = "modified_date")
    private Date modifiedDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_user_id")
    private AppUser creatorUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "modifier_user_id")
    private AppUser modifierUser;


    public AbstractProperty() {
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


    public AppUser getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(AppUser creatorUser) {
        this.creatorUser = creatorUser;
    }

    public AppUser getModifierUser() {
        return modifierUser;
    }

    public void setModifierUser(AppUser modifierUser) {
        this.modifierUser = modifierUser;
    }
}
