package com.example.service;

import com.example.client.MovieApiClient;
import com.example.dto.MovieDto;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieApiClient movieApiClient;

    public MovieService(MovieApiClient movieApiClient) {
        this.movieApiClient = movieApiClient;
    }

    public MovieDto[] getMoviesByPage(int page) {
        return movieApiClient.getMoviesByPage(page);
    }


}