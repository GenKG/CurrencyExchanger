package com.currencyExchanger.rates.util;

import java.security.SecureRandom;

public final class RandomEnum<T extends Enum<?>>{

    private static final SecureRandom random = new SecureRandom();

    public static <T extends Enum<?>> T randomEnum(Class<T> enumClass){
        int x = random.nextInt(enumClass.getEnumConstants().length);
        return enumClass.getEnumConstants()[x];
    }
}
