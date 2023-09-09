package com.currencyExchanger.rates.util;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDate {

    public static Date getRandomDate(){
        LocalDate startDate = LocalDate.of(1990,1,1);
        long start = startDate.toEpochDay();
        LocalDate endDate = LocalDate.now();
        long end = endDate.toEpochDay();
        return new Date(ThreadLocalRandom.current().nextLong(start,end));
    }
}
