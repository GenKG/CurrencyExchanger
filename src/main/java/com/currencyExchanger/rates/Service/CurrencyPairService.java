package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.Model.CurrencyPair;

import java.util.List;

public interface CurrencyPairService {
    List<CurrencyPair> getAll();

    CurrencyPair getCurrencyPairById(Long id);

    CurrencyPair save(CurrencyPair currencyPair);

    void delete(Long id);

    boolean update(CurrencyPair currencyPair, Long id);
}
