package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.DAO.CurrencyPairRepository;
import com.currencyExchanger.rates.Model.Currency;
import com.currencyExchanger.rates.Model.CurrencyPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service("cbApiOperations")
public class CbApiOperations implements CurrencyPairOperations {

    private CurrencyPairRepository repository;

    private CurrencyPair pair;

    @Autowired
    public CbApiOperations(CurrencyPairRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveNewValuePair(Currency base, Currency counter, Date date, Double valuePair) {
        pair = new CurrencyPair(base,counter,date,valuePair);
        repository.save(pair);
    }
}
