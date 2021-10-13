package com.example.entrevueSpringBoot.service;

import com.example.entrevueSpringBoot.entity.FilmEntity;
import com.example.entrevueSpringBoot.repository.FilmRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    final FilmRepository filmRepository;

    private FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public FilmEntity getFilmById(long id) {
        return filmRepository.getById(id);
    }

    public FilmEntity save(final FilmEntity filmEntity) {
        return filmRepository.save(filmEntity);
    }
}
