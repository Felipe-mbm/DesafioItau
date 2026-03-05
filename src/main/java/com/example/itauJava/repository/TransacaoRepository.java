package com.example.itauJava.repository;

import com.example.itauJava.dto.EstatisticasDTO;
import com.example.itauJava.dto.TransacaoDTO;
import com.example.itauJava.service.EstatisticaProperties;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoDTO> listaDeTransacoes = new ArrayList<>();
    private final EstatisticaProperties estatisticaProperties;

    public TransacaoRepository(EstatisticaProperties estatisticaProperties) {
        this.estatisticaProperties = estatisticaProperties;
    }

    public void salvarDados(TransacaoDTO transacao) {
        listaDeTransacoes.add(transacao);
    }

    public List<TransacaoDTO> listar() {
        return listaDeTransacoes;
    }

    public EstatisticasDTO estatistica(OffsetDateTime horaInicial) {

        if (listaDeTransacoes.isEmpty()) {
            return new EstatisticasDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        final var summary = listaDeTransacoes.stream()
                .filter(t -> t.dataHora().isAfter(horaInicial))
                .mapToDouble(t -> t.valor().doubleValue())
                .summaryStatistics();

        if (summary.getCount() == 0) {
            return new EstatisticasDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        return new EstatisticasDTO(
                summary.getCount(),
                summary.getAverage(),
                summary.getMax(),
                summary.getMin(),
                summary.getSum());
    }

    public void limparDados() {
        listaDeTransacoes.clear();
    }

    public void deletarDados() {
        listaDeTransacoes.clear();
    }

}
