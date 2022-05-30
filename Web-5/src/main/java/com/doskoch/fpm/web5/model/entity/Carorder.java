package com.doskoch.fpm.web5.model.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Carorder.SelectAllOrderTraces",
                query = "select o from Carorder o"),
        @NamedQuery(name = "Carorder.SelectOrdersInfoByCarDriver",
                query = "select o from Carorder o where o.cardriverByDriverId.id = " +
                        "           (select id from Cardriver where name=:Name)"),
        @NamedQuery(name = "Carorder.CardriverIdByName",
                query = "select c from Cardriver c where c.name = :Name")
})
public class Carorder {
    private int id;
    private String brand;
    private Integer mileage;
    private Byte isFinished;
    private String departure;
    private String destination;
    private Time startTime;
    private Cardriver cardriverByDriverId;

    public Carorder(String brand, Integer mileage, Byte isFinished, String departure, String destination, Time startTime) {
        this.brand = brand;
        this.mileage = mileage;
        this.isFinished = isFinished;
        this.departure = departure;
        this.destination = destination;
        this.startTime = startTime;
    }

    public Carorder() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "Mileage")
    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @Basic
    @Column(name = "isFinished")
    public Byte getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(Byte isFinished) {
        this.isFinished = isFinished;
    }

    @Basic
    @Column(name = "Departure")
    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    @Basic
    @Column(name = "Destination")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Basic
    @Column(name = "StartTime")
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carorder order = (Carorder) o;

        if (id != order.id) return false;
        if (!Objects.equals(brand, order.brand)) return false;
        if (!Objects.equals(mileage, order.mileage)) return false;
        if (!Objects.equals(isFinished, order.isFinished)) return false;
        if (!Objects.equals(departure, order.departure)) return false;
        if (!Objects.equals(destination, order.destination)) return false;
        if (!Objects.equals(startTime, order.startTime)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (mileage != null ? mileage.hashCode() : 0);
        result = 31 * result + (isFinished != null ? isFinished.hashCode() : 0);
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "DriverId", referencedColumnName = "Id")
    public Cardriver getCardriverByDriverId() {
        return cardriverByDriverId;
    }

    public void setCardriverByDriverId(Cardriver cardriverByDriverId) {
        this.cardriverByDriverId = cardriverByDriverId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "departure='" + departure + '\'' +
                ", startTime=" + startTime +
                '}';
    }
}
