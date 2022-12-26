package com.javarush.drogunov.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class FilmDTO {
    private String title;
    private List<CategoryDTO> categories;
    private List<ActorDTO> actors;
    private String description;
    private Integer releaseYear;
    private LanguageDTO language;
    private Integer originalLanguageId;
    private Integer rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    private BigDecimal replacementCost;
    private String rating;
    //TODO Set
    private String specialFeatures;
}
