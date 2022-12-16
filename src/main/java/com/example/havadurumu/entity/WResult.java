package com.example.havadurumu.entity;

import lombok.Data;

@Data
public class WResult {

    private Main main;
    private Weather[] weather;
}
