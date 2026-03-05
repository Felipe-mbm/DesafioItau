package com.example.itauJava.dto;

public record EstatisticasDTO(
        Long count,
        Double avg,
        Double max,
        Double min,
        Double sum
) {}
