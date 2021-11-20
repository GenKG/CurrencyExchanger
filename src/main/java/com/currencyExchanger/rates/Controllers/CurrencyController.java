package com.currencyExchanger.rates.Controllers;

import com.currencyExchanger.rates.DTO.CurrencyPairDTO;
import com.currencyExchanger.rates.Model.Currency;
import com.currencyExchanger.rates.Model.CurrencyPair;
import com.currencyExchanger.rates.Service.CurrencyPairService;
import com.currencyExchanger.rates.Service.CurrencyPairServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RestController
@RequestMapping(value = CurrencyController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CurrencyController {
    public static final String REST_URL = "/currencyPair";

   private final CurrencyPairService currencyPairService;

   @Autowired
    public CurrencyController(CurrencyPairServiceImpl currencyPairService) {
        this.currencyPairService = currencyPairService;
    }

    @GetMapping(value = {"/{id}"})
    public CurrencyPairDTO get(@PathVariable("id") Long id){
        return currencyPairService.getCurrencyPairById(id);
    }

    @GetMapping
    public List<CurrencyPairDTO> getAll(){
       return currencyPairService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public CurrencyPairDTO save(@RequestBody CurrencyPair currencyPair){
        return currencyPairService.save(currencyPair);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        currencyPairService.delete(id);
    }


    //Получение валютного курса на конкретную дату
    @GetMapping(value = "/{date}/{base}/{counter}")
    public Double searchPair(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                           @PathVariable("base")Currency base,
                           @PathVariable("counter") Currency counter) {
        return currencyPairService.getPairByDate(base, counter, date);
    }
}
