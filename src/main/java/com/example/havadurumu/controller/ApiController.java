package com.example.havadurumu.controller;


import com.example.havadurumu.dto.Main;
import com.example.havadurumu.dto.WResult;
import com.example.havadurumu.dto.Weather;
import com.example.havadurumu.repository.MainRepository;
import com.example.havadurumu.service.ApiServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {


    private final ApiServiceImpl apiService;
    private final MainRepository mainRepository;

    public ApiController(ApiServiceImpl apiService,
                         MainRepository mainRepository) {
        this.apiService = apiService;
        this.mainRepository = mainRepository;
    }


    @GetMapping("/")
    public ResponseEntity<WResult> getAllWeather() {
        WResult weatherDto = apiService.getAllWeather();
        return new ResponseEntity<>(weatherDto, HttpStatus.OK);
    }


    @PostMapping("/saveTemp")
    public ResponseEntity<Main> getSaveWeather() {
        Main main = apiService.getSaveWeather();
        return new ResponseEntity<>(main,HttpStatus.CREATED);
    }

    @PostMapping("/saveCloud")
    public ResponseEntity<Weather[]> getSaveCloud() {
        Weather[] weather = apiService.getSaveCloud();
        return new ResponseEntity<>(weather , HttpStatus.CREATED);
    }


}
