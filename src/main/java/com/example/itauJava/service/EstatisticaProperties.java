package com.example.itauJava.service;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
public record EstatisticaProperties(Integer segundos) {}
