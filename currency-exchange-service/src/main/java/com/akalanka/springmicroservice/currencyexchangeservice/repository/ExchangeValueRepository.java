package com.akalanka.springmicroservice.currencyexchangeservice.repository;

import com.akalanka.springmicroservice.currencyexchangeservice.domain.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue , Long> {
    ExchangeValue findByFromAndTo(String from,String to);
}
