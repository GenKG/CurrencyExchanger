package com.currencyExchanger.rates.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.*;

@Accessors(chain = true)
@Entity
@Data
public final class CurrencyPair implements Comparable<CurrencyPair> {
    @Column
    private final Currency base;
    @Column
    private final Currency counter;
    @Column
    private final Date date;
    @Column
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
