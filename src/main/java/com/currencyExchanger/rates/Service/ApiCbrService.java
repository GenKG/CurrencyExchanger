package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.Model.Currency;

public interface ApiCbrService {
    Double getValueForPair(Currency base,Currency counter);
}
