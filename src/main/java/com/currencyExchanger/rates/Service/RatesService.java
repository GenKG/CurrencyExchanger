package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.Model.Currency;
import com.currencyExchanger.rates.Model.CurrencyPair;
import com.currencyExchanger.rates.Util.*;
import org.springframework.stereotype.Controller;
import java.util.*;

@Controller
public class RatesService {

    public List<CurrencyPair> getAllRates(Integer rateSize){
        List<CurrencyPair> listPair = new ArrayList<>();
        for (int i = 0; i < rateSize;i++){
            listPair.add(new CurrencyPair(RandomEnum.randomEnum(Currency.class),
                    RandomEnum.randomEnum(Currency.class),
                    RandomDate.getRandomDate(),
                    RandomValue.randomDoubleValue(1000.00,0.0001,100.00)
                    ));
        }
       return listPair;
    }

    public void streamMap(){
        List<CurrencyPair> currencyPairs = getAllRates(30);
        System.out.println("---------------------------------");
        System.out.println("this stream sorts by date");
        currencyPairs.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("---------------------------------");
        System.out.println("this stream sorts by currency");
        currencyPairs.stream()
                .sorted((o1, o2) -> new CurrencyPairComparator().compare(o1,o2))
                .forEach(System.out::println);
        System.out.println("---------------------------------");
        System.out.println("this stream sorts by value");
        currencyPairs
                .stream()
                .sorted(new CurrencyPairValueComparator().reversed())
                .limit(5)
                .forEach(System.out::println);
    }

}
