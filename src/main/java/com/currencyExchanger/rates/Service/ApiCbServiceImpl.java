package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.Controllers.CbClient;
import com.currencyExchanger.rates.DTO.CbrDTO;
import com.currencyExchanger.rates.DTO.ISO;
import com.currencyExchanger.rates.Model.Currency;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public class ApiCbServiceImpl implements ApiCbrService {
    private  CbrDTO cbrDTO;

    private final CbClient cbClient;

    @Qualifier("cbApiOperations")
    private final CurrencyPairOperations cbApiOperations;

    @Autowired
    public ApiCbServiceImpl(CbClient cbClient, CurrencyPairOperations cbApiOperations) {
        this.cbClient = cbClient;
        this.cbApiOperations = cbApiOperations;
    }

    @PostConstruct
    public void init() throws JsonProcessingException {
        cbrDTO = new ObjectMapper().readValue(cbClient.getAllCbValue(),CbrDTO.class);
    }

    public Double getValueForPair(Currency base,Currency counter){
        Double baseValue = cbrDTO.getValute().get(ISO.valueOf(base.getDescription())).getValue();
        Double counterValue = cbrDTO.getValute().get(ISO.valueOf(counter.getDescription())).getValue();
        Double valuePair = Math.round(baseValue/counterValue  * 100.00)/ 100.0;
        cbApiOperations.saveNewValuePair(base,counter,cbrDTO.getDate(),valuePair);
        return valuePair;
    }
}
