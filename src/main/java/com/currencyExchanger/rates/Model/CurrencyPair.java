package com.currencyExchanger.rates.Model;

import lombok.Getter;
import lombok.Setter;
import java.util.*;


@Getter
@Setter
public final class CurrencyPair implements Comparable<CurrencyPair> {
    private final Currency base;

    private final Currency counter;

    private final Date date;

    private final Double valuePair;

    public CurrencyPair(Currency base, Currency counter, Date date,Double valuePair) {
        this.base = base;
        this.counter = counter;
        this.date = date;
        this.valuePair = valuePair;
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

    @Override
    public String toString() {
        return "CurrencyPair{" +
                "base=" + base +
                ", counter=" + counter +
                ", date=" + date +
                ", valuePair=" + valuePair +
                '}';
    }
}
