package com.javarush.drogunov.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentDTO {
    private Integer rentalId;
    private BigDecimal amount;
}
