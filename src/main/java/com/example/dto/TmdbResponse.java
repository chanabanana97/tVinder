package com.example.dto;

import lombok.Data;

@Data
public class TmdbResponse {
    private int page;
    private MovieDto[] results;
    private int totalPages;
    private int totalResults;
}
