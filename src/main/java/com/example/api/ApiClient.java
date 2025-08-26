package com.example.api;

import com.example.config.ApiClientConfig;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClient;


@Component
public class ApiClient {

    private final RestClient restClient;
    private final HttpHeaders httpHeaders;

    @SneakyThrows
    public ApiClient(ApiClientConfig apiClientConfig) {
        this.httpHeaders = new HttpHeaders();

        if (apiClientConfig.getAuthToken() == null || apiClientConfig.getAuthToken().isEmpty()) {
            throw new ResourceAccessException("Authorization token is required");
        }
        this.httpHeaders.add(HttpHeaders.AUTHORIZATION, apiClientConfig.getAuthToken());
        this.httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        this.restClient = RestClient.builder()
                .baseUrl(apiClientConfig.getBaseUrl())
                .defaultHeaders(headers -> headers.putAll(this.httpHeaders))
                .build();
    }

    public <T> T get(String uri, Class<T> responseType) {
        var result = restClient.get()
                .uri(uri)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(responseType);
        System.out.println(result);
        return result;

    }


}