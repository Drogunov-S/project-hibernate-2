package com.javarush.drogunov.model.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class CategoryDTO {
    private String name;
    private List<FilmDTO> films;
}
