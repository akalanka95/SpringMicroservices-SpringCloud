package com.akalanka.springmicroservice.currencyconversionservice.controller;

import com.akalanka.springmicroservice.currencyconversionservice.domain.CurrencyConvertor;
import com.akalanka.springmicroservice.currencyconversionservice.feign.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConvertorController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping(value = "/currency-convertor/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertor getCurrencyConvertorResult(@PathVariable String from,
                                                        @PathVariable String to,
                                                        @PathVariable BigDecimal quantity){
        Map<String,String> variable = new HashMap<String,String>();
        variable.put("from",from);
        variable.put("to",to);

        ResponseEntity<CurrencyConvertor> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/{from}/to/{to}", CurrencyConvertor.class, variable);
        System.out.println("this is the : " + responseEntity);
        CurrencyConvertor response = responseEntity.getBody();
        return new CurrencyConvertor(response.getId(),from,to,response.getMultiValue(),quantity,quantity.multiply(response.getMultiValue()),response.getPort());
    }

    @GetMapping(value = "/currency-convertor-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvertor getCurrencyConvertorResultFromFeign(@PathVariable String from,
                                                        @PathVariable String to,
                                                        @PathVariable BigDecimal quantity){

        CurrencyConvertor response = currencyExchangeServiceProxy.getTheExchaneValue(from,to);
        logger.info("{}",response);
        return new CurrencyConvertor(response.getId(),from,to,response.getMultiValue(),quantity,quantity.multiply(response.getMultiValue()),response.getPort());
    }
}
