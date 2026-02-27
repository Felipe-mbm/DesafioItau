package com.example.itauJava.controller;

import com.example.itauJava.dto.EstatisticasDTO;
import com.example.itauJava.service.EstatisticaProperties;
import com.example.itauJava.service.EstatisticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    @Autowired
    private EstatisticasService estatisticasService;

    @Autowired
    private EstatisticaProperties estatisticaProperties;

    @GetMapping
    public ResponseEntity estatistica() {
        return ResponseEntity.ok().body(estatisticasService.calcularEstatisticas());
    }
}
