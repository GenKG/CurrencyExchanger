package com.currencyExchanger.rates.util;

import com.currencyExchanger.rates.model.Currency;

import java.util.Comparator;

public class CurrencyComparator implements Comparator<Currency> {
    @Override
    public int compare(Currency o1,Currency o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
