package com.currencyExchanger.rates.service;

import com.currencyExchanger.rates.model.Currency;

public interface ApiCbrService {
    Double getValueForPair(Currency base,Currency counter);
}
