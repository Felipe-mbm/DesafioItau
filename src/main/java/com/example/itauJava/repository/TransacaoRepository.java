package com.example.itauJava.repository;

import com.example.itauJava.dto.TransacaoDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoDTO> listaDeTransacoes = new ArrayList<>();

    public void salvarDados(TransacaoDTO transacaoDTO) {
        listaDeTransacoes.add(transacaoDTO);
    }

    public List<TransacaoDTO> listar() {
        return listaDeTransacoes;
    }

    public void limparDados() {
        listaDeTransacoes.clear();
    }

    public void deletarDados() {
        listaDeTransacoes.clear();
    }

    public OffsetDateTime estatistica(OffsetDateTime horaInicial) {
        return null;
    }
}
