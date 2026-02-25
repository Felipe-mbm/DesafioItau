package com.example.itauJava.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EstatisticasDTO {

    private int count;
    private BigDecimal avg;
    private BigDecimal max;
    private BigDecimal min;
    private BigDecimal sum;

}
