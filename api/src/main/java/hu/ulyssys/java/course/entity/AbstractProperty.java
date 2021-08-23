package hu.ulyssys.java.course.entity;
import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractProperty extends AbstractEntity{

    @PastOrPresent
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

    @JoinColumn(name = "created_user_id")
    @ManyToOne
    private AppUser createdUser;

    @JoinColumn(name = "modified_user_id")
    @ManyToOne
    private AppUser modifiedUser;

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public AppUser getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(AppUser createdUser) {
        this.createdUser = createdUser;
    }

    public AppUser getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(AppUser modifiedUser) {
        this.modifiedUser = modifiedUser;
    }
}
