package com.example.havadurumu.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String main;
    private String description;
    private Date date;

}
