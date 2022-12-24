package com.javarush.drogunov.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "store")
public class Store {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private Integer storeId;
    
    @Column(name = "manager_staff_id")
    private Integer managerStaffId;
    
    @Column(name = "address_id")
    private Integer addressId;
    
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(Integer managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId=" + storeId +
                ", managerStaffId=" + managerStaffId +
                ", addressId=" + addressId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(storeId, store.storeId) && Objects.equals(managerStaffId, store.managerStaffId) && Objects.equals(addressId, store.addressId) && Objects.equals(lastUpdate, store.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, managerStaffId, addressId, lastUpdate);
    }
}
