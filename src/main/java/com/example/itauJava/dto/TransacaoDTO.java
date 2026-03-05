package com.example.itauJava.dto;

import java.time.OffsetDateTime;

public record TransacaoDTO(
         Double valor,
         OffsetDateTime dataHora
) {}
