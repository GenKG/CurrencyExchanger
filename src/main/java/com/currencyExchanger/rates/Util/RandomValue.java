package com.currencyExchanger.rates.Util;

import java.util.Random;

public final class RandomValue {

    private static Random random = new Random();

    public static double randomDoubleValue(final double maxRange, final double minRange, double rounding){
        double diff = maxRange - minRange;
        double value = random.nextDouble() * diff;
        return Math.round(value * rounding)/ rounding;
    }
}
