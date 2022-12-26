package com.javarush.drogunov.model.dto;

import com.javarush.drogunov.model.entity.City;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@AllArgsConstructor
@Data
public class AddressDTO {
    private String address;
    private String address2;
    private String district;
    private CityDTO cityDTO;
    private String postalCode;
    private String phone;
    
    public AddressDTO(String address, String district, CityDTO cityDTO, String postalCode, String phone) {
        this.address = address;
        this.district = district;
        this.cityDTO = cityDTO;
        this.postalCode = postalCode;
        this.phone = phone;
    }
}
