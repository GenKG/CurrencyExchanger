package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.Model.CurrencyPair;
import com.currencyExchanger.rates.Util.CurrencyPairComparator;


import java.util.*;
import java.util.stream.Collectors;

public class RatesService {

    CurrencyPair currencyPair;

    public List<CurrencyPair> getAllRates(Integer rateSize){
       return new ArrayList<>(rateSize);
    }

    public void StreamMap(){
        TreeMap<CurrencyPair,Double> sortedMap = new TreeMap<>(currencyPair.getAllCurrencyPair());
        sortedMap.entrySet()
                .stream()
                .forEach(System.out::println);

        currencyPair.getAllCurrencyPair()
                .entrySet()
                .stream()
                .sorted((o1, o2) -> new CurrencyPairComparator().compare(o1,o2))
                .forEach(System.out::println);

        currencyPair.getAllCurrencyPair()
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x,y)-> {throw new AssertionError();},
                        LinkedHashMap::new
                ));
    }
}
