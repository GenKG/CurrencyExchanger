package com.currencyExchanger.rates.util;

import com.currencyExchanger.rates.model.CurrencyPair;

import java.util.Comparator;

public class CurrencyPairValueComparator implements Comparator<CurrencyPair> {
    @Override
    public int compare(CurrencyPair o1, CurrencyPair o2) {
        return o1.getValuePair().compareTo(o2.getValuePair());
    }


}
