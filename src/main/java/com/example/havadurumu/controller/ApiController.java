package com.example.havadurumu.controller;


import com.example.havadurumu.entity.WResult;
import com.example.havadurumu.service.ApiServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {


    private final ApiServiceImpl apiService;

    public ApiController(ApiServiceImpl apiService) {
        this.apiService = apiService;
    }


    @GetMapping("/")
    public ResponseEntity<WResult> getAllWeather(){
        WResult weather = apiService.getAllWeather();
        return new ResponseEntity<>(weather , HttpStatus.OK);
    }
}
