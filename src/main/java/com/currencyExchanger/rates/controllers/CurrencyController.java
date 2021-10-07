package com.currencyExchanger.rates.controllers;

import com.currencyExchanger.rates.Model.CurrencyPair;
import com.currencyExchanger.rates.Service.CurrencyPairServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RestController
@RequestMapping(value = CurrencyController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyController {
    public static final String REST_URL = "/currencyPair";

   private final CurrencyPairServiceImpl currencyPairService;

   @Autowired
    public CurrencyController(CurrencyPairServiceImpl currencyPairService) {
        this.currencyPairService = currencyPairService;
    }

    @GetMapping(value = {"/{id}"})
    public CurrencyPair get(@PathVariable("id") Long id){
        return currencyPairService.getCurrencyPairById(id);
    }

    @GetMapping
    public List<CurrencyPair> getAll(){
       return currencyPairService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CurrencyPair save(@RequestBody CurrencyPair currencyPair){
        return currencyPairService.save(currencyPair);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        currencyPairService.delete(id);
    }

}
