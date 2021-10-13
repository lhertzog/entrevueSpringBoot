package com.example.entrevueSpringBoot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FilmDTO {

    private Long id;
    private String titre;
    private String description;
    private List<ActeurDTO> acteurs;
}
