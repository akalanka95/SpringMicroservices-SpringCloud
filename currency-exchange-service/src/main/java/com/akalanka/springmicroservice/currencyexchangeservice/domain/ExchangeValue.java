package com.akalanka.springmicroservice.currencyexchangeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeValue {

    @Id
    private Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    @Column(name = "multi_value")
    private BigDecimal multiValue;
    private int port;

    public ExchangeValue(Long id, String from, String to, BigDecimal multiValue) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.multiValue = multiValue;
    }
}
