package com.currencyExchanger.rates.service;

import com.currencyExchanger.rates.DAO.CurrencyPairRepository;
import com.currencyExchanger.rates.model.Currency;
import com.currencyExchanger.rates.model.CurrencyPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service("cbApiOperations")
public class CbApiOperations implements CurrencyPairOperations {

    private final CurrencyPairRepository repository;

    private CurrencyPair pair;

    @Autowired
    public CbApiOperations(CurrencyPairRepository repository) {
        this.repository = repository;
    }

    @Override
    public CurrencyPair saveNewValuePair(Currency base, Currency counter, Date date, Double valuePair) {
        pair = new CurrencyPair(base,counter,date,valuePair);
        return repository.save(pair);
    }
}
