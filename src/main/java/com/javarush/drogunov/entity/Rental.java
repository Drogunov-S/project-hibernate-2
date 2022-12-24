package com.javarush.drogunov.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rental")
public class Rental {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "rental_id")
    private Integer rentalId;
    
    @Column(name = "rental_date")
    private Timestamp rentalDate;
    
    @Column(name = "inventory_id")
    private Integer inventoryId;
    
    @Column(name = "customer_id")
    private Integer customerId;
    
    @Column(name = "return_date")
    private Timestamp returnDate;
    
    @Column(name = "staff_id")
    private Integer staffId;
    
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Integer getRentalId() {
        return rentalId;
    }

    public void setRentalId(Integer rentalId) {
        this.rentalId = rentalId;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", rentalDate=" + rentalDate +
                ", inventoryId=" + inventoryId +
                ", customerId=" + customerId +
                ", returnDate=" + returnDate +
                ", staffId=" + staffId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(rentalId, rental.rentalId) && Objects.equals(rentalDate, rental.rentalDate) && Objects.equals(inventoryId, rental.inventoryId) && Objects.equals(customerId, rental.customerId) && Objects.equals(returnDate, rental.returnDate) && Objects.equals(staffId, rental.staffId) && Objects.equals(lastUpdate, rental.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, rentalDate, inventoryId, customerId, returnDate, staffId, lastUpdate);
    }
}
