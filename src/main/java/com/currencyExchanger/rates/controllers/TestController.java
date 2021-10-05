package com.currencyExchanger.rates.controllers;

import com.currencyExchanger.rates.Model.Currency;
import com.currencyExchanger.rates.Model.CurrencyPair;
import com.currencyExchanger.rates.Service.RatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class TestController {

    private RatesService ratesService;

    @Autowired
    public TestController(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    public void rates() throws ParseException {
        ratesService.streamMap();
        ratesService.allSQLQuery();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNow = dateFormat.parse(dateFormat.format(calendar.getTime()));
        ratesService.getPojo(new CurrencyPair(Currency.BAM,Currency.BZD,dateNow, 35.05));
    }
}
