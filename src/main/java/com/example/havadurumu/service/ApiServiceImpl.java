package com.example.havadurumu.service;


import com.example.havadurumu.entity.WResult;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;



    public ApiServiceImpl(RestTemplate restTemplate, HttpHeaders httpHeaders) {
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
    }

    private static final String weather_api = "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=8e791c790c425f38523ec9125c86efd3";



    @Override
    public WResult getAllWeather() {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<WResult> response = restTemplate
                .exchange(weather_api , HttpMethod.GET , entity , WResult.class);
        return response.getBody();
    }
}



