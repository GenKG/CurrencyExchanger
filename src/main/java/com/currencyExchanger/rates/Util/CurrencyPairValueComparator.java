package com.currencyExchanger.rates.Util;

import com.currencyExchanger.rates.Model.CurrencyPair;

import java.util.Comparator;

public class CurrencyPairValueComparator implements Comparator<CurrencyPair> {
    @Override
    public int compare(CurrencyPair o1, CurrencyPair o2) {
        return o1.getValuePair().compareTo(o2.getValuePair());
    }


}
