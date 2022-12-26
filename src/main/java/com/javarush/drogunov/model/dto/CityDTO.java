package com.javarush.drogunov.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CityDTO {
    private String city;
    private CountryDTO country;
}
