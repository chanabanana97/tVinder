package com.example.controller;

import com.example.dto.MovieDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.MovieService;


@RestController
@RequestMapping("/movies")
public class MovieController {

        private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public MovieDto[] getMoviesByPage(@RequestParam int page) {
        return movieService.getMoviesByPage(page);
    }

}