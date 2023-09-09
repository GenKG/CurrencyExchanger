package com.currencyExchanger.rates.util;

import com.currencyExchanger.rates.model.CurrencyPair;
import java.util.Comparator;

public class CurrencyPairComparator implements Comparator<CurrencyPair> {

    public int compare(CurrencyPair o1, CurrencyPair o2) {
           return o1.getBase().compareTo(o2.getBase());
    }
}
