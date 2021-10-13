package com.example.entrevueSpringBoot.mapper;

import com.example.entrevueSpringBoot.dto.ActeurDTO;
import com.example.entrevueSpringBoot.dto.FilmDTO;
import com.example.entrevueSpringBoot.entity.ActeurEntity;
import com.example.entrevueSpringBoot.entity.FilmEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FilmMapperTest {

    @Test
    void filmEntityToFilmDTO() {
        FilmEntity filmEntity = new FilmEntity();

        filmEntity.setId(1L);
        filmEntity.setTitre("Star Wars: The Empire Strikes Back");
        filmEntity.setDescription("Darth Vader is adamant about turning Luke Skywalker to the dark side.");

        ActeurEntity acteurEntity1 = new ActeurEntity();
        acteurEntity1.setId(2L);
        acteurEntity1.setNom("Ford");
        acteurEntity1.setPrenom("Harrison");

        ActeurEntity acteurEntity2 = new ActeurEntity();
        acteurEntity2.setId(3L);
        acteurEntity2.setNom("Hamill");
        acteurEntity2.setPrenom("Mark");

        List<ActeurEntity> acteurEntitys = new ArrayList<>();
        acteurEntitys.add(acteurEntity1);
        acteurEntitys.add(acteurEntity2);
        filmEntity.setActeurs(acteurEntitys);

        FilmDTO filmDTO = FilmMapper.INSTANCE.filmEntityToFilmDTO(filmEntity);

        Assertions.assertEquals(filmEntity.getId(), filmDTO.getId());
        Assertions.assertEquals(filmEntity.getTitre(), filmDTO.getTitre());
        Assertions.assertEquals(filmEntity.getDescription(), filmDTO.getDescription());

        for (int i = 0; i < acteurEntitys.size(); ++i) {
            Assertions.assertEquals(filmEntity.getActeurs().get(i).getId(), filmDTO.getActeurs().get(i).getId());
            Assertions.assertEquals(filmEntity.getActeurs().get(i).getNom(), filmDTO.getActeurs().get(i).getNom());
            Assertions.assertEquals(filmEntity.getActeurs().get(i).getPrenom(), filmDTO.getActeurs().get(i).getPrenom());
        }
    }

    @Test
    void filmDTOToFilmEntity() {
        FilmDTO filmDTO = new FilmDTO();

        filmDTO.setId(1L);
        filmDTO.setTitre("Star Wars: The Empire Strikes Back");
        filmDTO.setDescription("Darth Vader is adamant about turning Luke Skywalker to the dark side.");

        ActeurDTO acteurDTO1 = new ActeurDTO();
        acteurDTO1.setId(2L);
        acteurDTO1.setNom("Ford");
        acteurDTO1.setPrenom("Harrison");

        ActeurDTO acteurDTO2 = new ActeurDTO();
        acteurDTO2.setId(3L);
        acteurDTO2.setNom("Hamill");
        acteurDTO2.setPrenom("Mark");

        List<ActeurDTO> acteurDTOs = new ArrayList<>();
        acteurDTOs.add(acteurDTO1);
        acteurDTOs.add(acteurDTO2);
        filmDTO.setActeurs(acteurDTOs);

        FilmEntity filmEntity = FilmMapper.INSTANCE.filmDTOToFilmEntity(filmDTO);

        Assertions.assertEquals(filmDTO.getId(), filmEntity.getId());
        Assertions.assertEquals(filmDTO.getTitre(), filmEntity.getTitre());
        Assertions.assertEquals(filmDTO.getDescription(), filmEntity.getDescription());

        for (int i = 0; i < acteurDTOs.size(); ++i) {
            Assertions.assertEquals(filmDTO.getActeurs().get(i).getId(), filmEntity.getActeurs().get(i).getId());
            Assertions.assertEquals(filmDTO.getActeurs().get(i).getNom(), filmEntity.getActeurs().get(i).getNom());
            Assertions.assertEquals(filmDTO.getActeurs().get(i).getPrenom(), filmEntity.getActeurs().get(i).getPrenom());
        }
    }
}