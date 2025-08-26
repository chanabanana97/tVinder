package com.example.dto;

import lombok.Data;

@Data
public class MovieDto {
    private int id;
    private String title;
    private String overview;
    private String poster_path;
    private String backdrop_path;
    private String original_title;
    private String release_date;
    private String original_language;
    private double popularity;
    private double vote_average;
    private int vote_count;
    private boolean adult;
    private int[] genre_ids;

}
