package com.example.itauJava.service;

import com.example.itauJava.dto.TransacaoDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {
    public void validarTransacao(TransacaoDTO transacaoDTO) {
        if (transacaoDTO.getValor().compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Erro: Essa transção não é válid! Transações devem ter o valor maior ou igual a 0.");

        if (transacaoDTO.getDataHora().isAfter(OffsetDateTime.now()))
            throw new IllegalArgumentException("Erro: Isso não é uma transação válida! Data de transação inválida.");

        if (transacaoDTO.getValor() == null)
            throw new IllegalArgumentException("Erro: É necessário a transação possuir um valor.");

        if (transacaoDTO.getDataHora() == null)
            throw new IllegalArgumentException("Erro: É preciso ter uma data e hora na trasação.");
    }

}
