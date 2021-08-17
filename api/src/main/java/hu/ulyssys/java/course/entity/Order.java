package hu.ulyssys.java.course.entity;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_furniture")
public class Order extends AbstractProperty{

    @Column(name = "delivery_date",nullable = false)
    private Date deliveryDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "courier_id", nullable = false)
    private Courier courier;

    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name = "furnitures_id")
    @Min(value = 1)
    private List<Furniture> furnitures;

    @Column(name = "settlement",nullable = false)
    @Max(value = 200)
    private String settlement;

    @Column(name = "public_place",nullable = false)
    @Max(value = 200)
    private String publicPlace;

    @Column(name = "public_place_type",nullable = false)
    private String publicPlaceType;

    @Column(name = "house_of_number",nullable = false)
    @Max(value = 200)
    private String houseOfNumber;


    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Courier getCourier() {
       return courier;
    }

    public void setCourier(Courier courier) {
       this.courier = courier;
    }

    public List<Furniture> getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(List<Furniture> furnitures) {
        this.furnitures = furnitures;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getPublicPlaceType() {
        return publicPlaceType;
    }

    public void setPublicPlaceType(String publicPlaceType) {
        this.publicPlaceType = publicPlaceType;
    }

    public String getHouseOfNumber() {
        return houseOfNumber;
    }

    public void setHouseOfNumber(String houseOfNumber) {
        this.houseOfNumber = houseOfNumber;
    }
}
