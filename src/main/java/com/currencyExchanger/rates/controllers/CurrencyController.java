package com.currencyExchanger.rates.controllers;

import com.currencyExchanger.rates.DTO.CurrencyPairDTO;
import com.currencyExchanger.rates.model.Currency;
import com.currencyExchanger.rates.model.CurrencyPair;
import com.currencyExchanger.rates.service.CurrencyPairService;
import com.currencyExchanger.rates.service.CurrencyPairServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = CurrencyController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyController {
    public static final String REST_URL = "/currencyPair";

    private static final Logger LOG = LogManager.getLogger(CurrencyController.class);

    private final CurrencyPairService currencyPairService;

    @Autowired
    public CurrencyController(CurrencyPairServiceImpl currencyPairService) {
        this.currencyPairService = currencyPairService;
    }

    @GetMapping(value = {"/{id}"})
    public CurrencyPairDTO get(@PathVariable("id") Long id) {
        LOG.info("trying get currency by id");
        return currencyPairService.getCurrencyPairById(id);
    }

    @GetMapping
    public List<CurrencyPairDTO> getAll() {
        LOG.info("trying all get currency");
        return currencyPairService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CurrencyPairDTO save(@RequestBody CurrencyPair currencyPair) {
        LOG.info("trying to save currency pair");
        return currencyPairService.save(currencyPair);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOG.info("trying delete currency pair with id: {}", id);
        currencyPairService.delete(id);
    }


    //Получение валютного курса на конкретную дату
    @GetMapping(value = "/{date}/{base}/{counter}")
    public Double searchPair(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                             @PathVariable("base") Currency base,
                             @PathVariable("counter") Currency counter) {
        LOG.info("trying get currency pair by date: {} ", date);
        return currencyPairService.getPairByDate(base, counter, date);
    }
}
