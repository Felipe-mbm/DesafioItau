package com.example.itauJava.controller;

import com.example.itauJava.repository.TransacaoRepository;
import com.example.itauJava.dto.TransacaoDTO;
import com.example.itauJava.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacoesController {

    private final TransacaoService transacaoService;
    private final TransacaoRepository transacaoRepository;

    public TransacoesController(TransacaoService transacaoService, TransacaoRepository transacaoRepository) {
        this.transacaoService = transacaoService;
        this.transacaoRepository = transacaoRepository;
    }

    @PostMapping
    public ResponseEntity adicionar(@RequestBody TransacaoDTO transacaoDTO) {

        try {
            transacaoService.validarTransacao(transacaoDTO);
            transacaoRepository.salvarDados(transacaoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(transacaoRepository.listar());

        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity listar() {
        return ResponseEntity.ok().body(transacaoRepository.listar());
    }

    @DeleteMapping
    public ResponseEntity deletar() {
        transacaoRepository.limparDados();
        return ResponseEntity.ok().build();
    }

}
