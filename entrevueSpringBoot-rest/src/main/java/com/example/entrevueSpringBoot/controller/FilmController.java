package com.example.entrevueSpringBoot.controller;

import com.example.entrevueSpringBoot.dto.FilmDTO;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/film")
public interface FilmController {


    @GetMapping("/{id}")
    @ResponseBody
    FilmDTO getFilm(@PathVariable long id);


    @PostMapping
    @ResponseBody
    FilmDTO saveFilm(@RequestBody FilmDTO filmDTO);

}
