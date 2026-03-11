package com.example.itauJava.controller;

import com.example.itauJava.dto.EstatisticasDTO;
import com.example.itauJava.repository.TransacaoRepository;
import com.example.itauJava.service.EstatisticaProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
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

        log.info("Estatísticas dos últimos {} segundos", estatisticaProperties.segundos());
        final OffsetDateTime horaInicial = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());

        return transacaoRepository.estatistica(horaInicial);
    }
}
