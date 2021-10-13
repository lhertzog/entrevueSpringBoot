package com.example.entrevueSpringBoot.controller.impl;

import com.example.entrevueSpringBoot.controller.FilmController;
import com.example.entrevueSpringBoot.dto.FilmDTO;
import com.example.entrevueSpringBoot.entity.FilmEntity;
import com.example.entrevueSpringBoot.mapper.FilmMapper;
import com.example.entrevueSpringBoot.service.FilmService;
import org.springframework.stereotype.Controller;

@Controller
public class FilmControllerImpl implements FilmController {

    private final FilmService filmService;
    private final FilmMapper filmMapper;

    private FilmControllerImpl(FilmService filmService, FilmMapper filmMapper) {
        this.filmService = filmService;
        this.filmMapper = filmMapper;
    }


    public FilmDTO getFilm(long id) {
        FilmEntity filmEntity = filmService.getFilmById(id);

        return filmMapper.filmEntityToFilmDTO(filmEntity);
    }


    public FilmDTO saveFilm(FilmDTO filmDTO) {
        FilmEntity filmEntity = filmMapper.filmDTOToFilmEntity(filmDTO);

        FilmEntity filmEntityResult = filmService.save(filmEntity);

        return filmMapper.filmEntityToFilmDTO(filmEntityResult);
    }
}
