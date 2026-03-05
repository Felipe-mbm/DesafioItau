package com.example.itauJava.controller;

import com.example.itauJava.dto.EstatisticasDTO;
import com.example.itauJava.repository.TransacaoRepository;
import com.example.itauJava.service.EstatisticaProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    private final EstatisticaProperties estatisticaProperties;
    private final TransacaoRepository transacaoRepository;

    public EstatisticasController(EstatisticaProperties estatisticaProperties, TransacaoRepository transacaoRepository) {
        this.estatisticaProperties = estatisticaProperties;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    public EstatisticasDTO estatistica() {

        final OffsetDateTime horaInicial = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());

        return transacaoRepository.estatistica(horaInicial);
    }
}
