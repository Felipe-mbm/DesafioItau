package com.example.itauJava.service;

import com.example.itauJava.dto.EstatisticasDTO;
import com.example.itauJava.dto.TransacaoDTO;
import com.example.itauJava.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class EstatisticasService {

    private final TransacaoRepository transacaoRepository;

    public EstatisticasService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    public EstatisticasDTO calcularEstatisticas() {

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

        return estatisticasDTO;
    }
}
