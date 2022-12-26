package com.javarush.drogunov.model.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class RentalDTO {
    private Integer inventoryId;
    private Integer customerId;
    private Integer staffId;
    private Timestamp returnDate;
}
