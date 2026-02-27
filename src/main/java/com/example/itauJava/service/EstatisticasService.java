package com.example.itauJava.service;

import com.example.itauJava.dto.EstatisticasDTO;
import com.example.itauJava.dto.TransacaoDTO;
import com.example.itauJava.repository.TransacaoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;

@Service
public class EstatisticasService {

    private final TransacaoRepository transacaoRepository;
    private final EstatisticaProperties estatisticaProperties;

    public EstatisticasService(TransacaoRepository transacaoRepository, EstatisticaProperties estatisticaProperties) {
        this.transacaoRepository = transacaoRepository;
        this.estatisticaProperties = estatisticaProperties;
    }

    public ResponseEntity calcularEstatisticas() {

        final OffsetDateTime horaInicial = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());
        BigDecimal valorMax = null;
        BigDecimal valorMin = null;
        BigDecimal sum = BigDecimal.ZERO;
        int count = transacaoRepository.listar().size();

        EstatisticasDTO estatisticasDTO = new EstatisticasDTO();

        for (TransacaoDTO estatisticas : transacaoRepository.listar()) {

            if (estatisticas.getValor().compareTo(transacaoRepository.listar().get(0).getValor()) > 0)
                valorMax = estatisticas.getValor();

            if (estatisticas.getValor().compareTo(transacaoRepository.listar().get(0).getValor()) < 0)
                valorMin = estatisticas.getValor();

            sum = sum.add(estatisticas.getValor());

        }

        estatisticasDTO.setCount(count);
        estatisticasDTO.setAvg(sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP));
        estatisticasDTO.setMax(valorMax);
        estatisticasDTO.setMin(valorMin);
        estatisticasDTO.setSum(sum);

        return ResponseEntity.ok().body(transacaoRepository.estatistica(horaInicial));
    }
}
