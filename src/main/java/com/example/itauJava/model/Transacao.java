package com.example.itauJava.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    @NotNull(message = "O valor da transação é obrigatório.")
    @Positive(message = "O valor da transação deve ser maior que zero.")
    private BigDecimal valor;
    private OffsetDateTime dataHora;
}
