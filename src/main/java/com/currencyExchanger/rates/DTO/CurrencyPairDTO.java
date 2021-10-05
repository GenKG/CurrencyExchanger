package com.currencyExchanger.rates.DTO;

import com.currencyExchanger.rates.Model.Currency;
import lombok.Data;

import java.util.Date;

@Data
public class CurrencyPairDTO {

    Currency currencyBase;

    Currency currencyCounter;

    Date date;

    Double value;


    public Currency getCurrencyBase() {
        return currencyBase;
    }

    public void setCurrencyBase(Currency currencyBase) {
        this.currencyBase = currencyBase;
    }

    public Currency getCurrencyCounter() {
        return currencyCounter;
    }

    public void setCurrencyCounter(Currency currencyCounter) {
        this.currencyCounter = currencyCounter;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
