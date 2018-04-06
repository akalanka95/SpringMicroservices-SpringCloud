package com.akalanka.springmicroservice.currencyconversionservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConvertor {

    private Long id;
    private String from;
    private String to;
    private BigDecimal multiValue;
    private BigDecimal quantity;
    private BigDecimal totalCalculation;
    private int port;

}
