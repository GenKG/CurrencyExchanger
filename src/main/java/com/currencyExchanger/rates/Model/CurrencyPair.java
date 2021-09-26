package com.currencyExchanger.rates.Model;

import lombok.Getter;
import lombok.Setter;
import java.util.*;


@Getter
@Setter
public final class CurrencyPair implements Comparable<CurrencyPair> {
    private Currency base;

    private Currency counter;

    private Date date;

    private String currencyPair;

    private Double valuePair;

    private Map<CurrencyPair, Double> allCurrencyPair;

    private Map<Currency, Double> allCurrency;

    public CurrencyPair(Currency base, Currency counter, Date date) {
        this.base = base;
        this.counter = counter;
        this.date = date;
        allCurrencyPair.put(this,createValuePair(base,counter));
    }

    private double createValuePair(Currency base, Currency counter){
         valuePair = allCurrency.get(counter) * 100 / allCurrency.get(base);
         return valuePair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyPair that = (CurrencyPair) o;
        return base == that.base &&
                counter == that.counter;
    }

    @Override
    public int hashCode() {
        return base.hashCode() ^ counter.hashCode();
    }

    @Override
    public int compareTo(CurrencyPair o) {
        if (o.date.getTime() > this.date.getTime())
            return -1;
        else if (o.date.getTime() < this.date.getTime()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
