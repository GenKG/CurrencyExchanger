package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.Model.Currency;

import java.util.Date;

public interface CurrencyPairOperations {
    void saveNewValuePair(Currency base, Currency counter, Date date, Double valuePair);
}
