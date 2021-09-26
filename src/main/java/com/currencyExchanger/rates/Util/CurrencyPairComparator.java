package com.currencyExchanger.rates.Util;

import com.currencyExchanger.rates.Model.CurrencyPair;
import java.util.Comparator;
import java.util.Map;

public class CurrencyPairComparator implements Comparator<Map.Entry<CurrencyPair, Double>> {

    @Override
    public int compare(Map.Entry<CurrencyPair, Double> o1, Map.Entry<CurrencyPair, Double> o2) {
        return o1.getKey().getBase().getDescription().compareTo(o2.getKey().getBase().getDescription());
    }
}
