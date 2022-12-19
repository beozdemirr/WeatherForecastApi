package com.example.havadurumu.service;

import com.example.havadurumu.dto.Main;
import com.example.havadurumu.dto.WResult;
import com.example.havadurumu.dto.Weather;
import org.springframework.stereotype.Service;

@Service
public interface ApiService {

 public WResult getAllWeather() ;
 public Main getSaveWeather() ;
 public Weather[] getSaveCloud();
}
