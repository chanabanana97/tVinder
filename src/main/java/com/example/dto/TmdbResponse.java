package com.example.dto;

import lombok.Data;

@Data
public class TmdbResponse {
    private int page;
    private MovieDto[] results;
    private int total_pages;
    private int total_results;
}
