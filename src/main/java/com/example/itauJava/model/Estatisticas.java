package com.example.itauJava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Estatisticas {
    private int count;
    private BigDecimal avg;
    private BigDecimal max;
    private BigDecimal min;
    private BigDecimal sum;
}
