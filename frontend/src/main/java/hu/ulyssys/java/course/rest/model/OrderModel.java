package hu.ulyssys.java.course.rest.model;

import hu.ulyssys.java.course.entity.Courier;
import hu.ulyssys.java.course.entity.Furniture;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderModel extends CoreRestModel{

    private Date deliveryDate;

    private Courier courier;

    private List<Furniture> furnitures = new ArrayList<>();

    private String settlement;

    private String publicPlace;

    private String publicPlaceType;

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
