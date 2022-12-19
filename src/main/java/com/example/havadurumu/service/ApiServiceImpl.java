package com.example.havadurumu.service;
import com.example.havadurumu.dto.Main;
import com.example.havadurumu.dto.WResult;
import com.example.havadurumu.dto.Weather;
import com.example.havadurumu.entity.MainEntity;
import com.example.havadurumu.entity.WeatherEntity;
import com.example.havadurumu.repository.MainRepository;
import com.example.havadurumu.repository.WeatherRepository;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Date;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {
    private final RestTemplate restTemplate;
    private final HttpHeaders httpHeaders;

    private final MainRepository mainRepository;
    private final WeatherRepository weatherRepository;

    public ApiServiceImpl(RestTemplate restTemplate, HttpHeaders httpHeaders, MainRepository mainRepository, WeatherRepository weatherRepository) {
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
        this.mainRepository = mainRepository;
        this.weatherRepository = weatherRepository;
    }
    private static final String weather_api =
            "https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=8e791c790c425f38523ec9125c86efd3";
    @Override
    public WResult getAllWeather() {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> dto = new HttpEntity<>(httpHeaders);
        ResponseEntity<WResult> response = restTemplate.exchange(weather_api, HttpMethod.GET, dto, WResult.class);
        return response.getBody();
    }

    @Override
    public Main getSaveWeather() {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> dto = new HttpEntity<>(httpHeaders);
        ResponseEntity<WResult> response = restTemplate.exchange(weather_api, HttpMethod.GET, dto, WResult.class);
        Main main = response.getBody().getMain();
        MainEntity mainEntity = new MainEntity();
        mainEntity.setTemp(main.getTemp());
        mainEntity.setFeels_like(main.getFeels_like());
        mainEntity.setTemp_min(main.getTemp_min());
        mainEntity.setTemp_max(main.getTemp_max());
        mainEntity.setDate(new Date());
        mainRepository.save(mainEntity);
        return response.getBody().getMain();
    }

    @Override
    public Weather[] getSaveCloud() {
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> dto = new HttpEntity<>(httpHeaders);
        ResponseEntity<WResult> response = restTemplate.exchange(weather_api, HttpMethod.GET, dto, WResult.class);
        Weather[] weather = response.getBody().getWeather();
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setMain(weather[0].getMain());
        weatherEntity.setDescription(weather[0].getDescription());
        weatherEntity.setDate(new Date());
        weatherRepository.save(weatherEntity);
        return weather;
    }

}





