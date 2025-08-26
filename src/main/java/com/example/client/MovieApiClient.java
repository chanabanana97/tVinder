package com.example.client;

import com.example.dto.MovieDto;
import com.example.api.ApiClient;
import com.example.dto.TmdbResponse;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MovieApiClient {

    private final ApiClient client;

    public MovieApiClient(ApiClient client) {
        this.client = client;
    }

    public MovieDto[] getMoviesByPage(int page) {
        String url = String.format("discover/movie?language=en-US&page=%d&sort_by=popularity.desc", page);
        var response = client.get(url, TmdbResponse.class);
        System.out.println(Arrays.stream(response.getResults()).findFirst());

        return response.getResults();
    }
}
