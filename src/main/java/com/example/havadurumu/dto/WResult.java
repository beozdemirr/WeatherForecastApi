package com.example.havadurumu.dto;

import lombok.Data;

@Data
public class WResult {
    private Main main;
    private Weather[] weather;
}
