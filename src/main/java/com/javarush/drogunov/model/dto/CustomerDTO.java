package com.javarush.drogunov.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Integer storeId;
    private AddressDTO addressDTO;
}
