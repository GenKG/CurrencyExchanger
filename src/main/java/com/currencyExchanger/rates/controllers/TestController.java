package com.currencyExchanger.rates.controllers;

import com.currencyExchanger.rates.Config.JDBCPostgreSQLConnect;
import com.currencyExchanger.rates.Service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private RatesService ratesService;

    @Autowired
    public TestController(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @GetMapping(value = "test")
    public void rates(){
        ratesService.streamMap();
        JDBCPostgreSQLConnect.connection();

    }
}
