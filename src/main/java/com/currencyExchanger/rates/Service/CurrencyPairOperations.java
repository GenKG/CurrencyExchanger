package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.Model.Currency;
import com.currencyExchanger.rates.Model.CurrencyPair;

import java.util.Date;

public interface CurrencyPairOperations {
    CurrencyPair saveNewValuePair(Currency base, Currency counter, Date date, Double valuePair);
}
