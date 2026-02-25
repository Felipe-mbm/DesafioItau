package com.example.itauJava.controller;

import com.example.itauJava.dto.EstatisticasDTO;
import com.example.itauJava.service.EstatisticasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {

    private final EstatisticasService estatisticasService;

    public EstatisticasController(EstatisticasService estatisticasService) {
        this.estatisticasService = estatisticasService;
    }

    @GetMapping
    public ResponseEntity<EstatisticasDTO> estatisticas() {
        return ResponseEntity.ok().body(estatisticasService.calcularEstatisticas());
    }
}
