package com.example.havadurumu.repository;


import com.example.havadurumu.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface WeatherRepository  extends JpaRepository<WeatherEntity, Long> {

}

