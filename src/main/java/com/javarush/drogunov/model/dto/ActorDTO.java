package com.javarush.drogunov.model.dto;

import com.javarush.drogunov.model.entity.Film;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ActorDTO {
    private String firstName;
    private String lastName;
    private List<FilmDTO> films;
    
}
