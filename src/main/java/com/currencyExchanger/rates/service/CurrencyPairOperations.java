package com.currencyExchanger.rates.service;

import com.currencyExchanger.rates.model.Currency;
import com.currencyExchanger.rates.model.CurrencyPair;

import java.util.Date;

public interface CurrencyPairOperations {
    CurrencyPair saveNewValuePair(Currency base, Currency counter, Date date, Double valuePair);
}
