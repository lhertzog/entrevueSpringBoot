package com.example.entrevueSpringBoot.controller.impl;

import com.example.entrevueSpringBoot.dto.FilmDTO;
import com.example.entrevueSpringBoot.entity.FilmEntity;
import com.example.entrevueSpringBoot.mapper.FilmMapper;
import com.example.entrevueSpringBoot.service.FilmService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class FilmControllerImplTest {

    @InjectMocks
    private FilmControllerImpl filmController;

    @Mock
    private FilmMapper filmMapper;

    @Mock
    private FilmService filmService;

    @Test
    void getFilm() {
        FilmDTO filmDTO = new FilmDTO();
        Mockito.when(filmService.getFilmById(Mockito.anyLong())).thenReturn(new FilmEntity());
        Mockito.when(filmMapper.filmEntityToFilmDTO(Mockito.any())).thenReturn(filmDTO);

        FilmDTO res = filmController.getFilm(1L);

        Assertions.assertEquals(filmDTO, res);
    }

    @Test
    void saveFilm() {
        FilmDTO filmDTO = new FilmDTO();
        Mockito.when(filmMapper.filmDTOToFilmEntity(Mockito.any())).thenReturn(new FilmEntity());
        Mockito.when(filmService.save(Mockito.any())).thenReturn(new FilmEntity());
        Mockito.when(filmMapper.filmEntityToFilmDTO(Mockito.any())).thenReturn(filmDTO);

        FilmDTO res = filmController.saveFilm(new FilmDTO());

        Assertions.assertEquals(filmDTO, res);
    }


}