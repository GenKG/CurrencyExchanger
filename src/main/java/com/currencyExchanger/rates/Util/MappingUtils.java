package com.currencyExchanger.rates.Util;

import com.currencyExchanger.rates.DTO.CurrencyPairDTO;
import com.currencyExchanger.rates.Model.CurrencyPair;

public class MappingUtils {
    public static CurrencyPairDTO mapToPairDTO(CurrencyPair entity){
        CurrencyPairDTO dto = new CurrencyPairDTO();
        dto.setCurrencyBase(entity.getBase());
        dto.setCurrencyCounter(entity.getCounter());
        dto.setDate(entity.getDate());
        dto.setValue(entity.getValuePair());
        return dto;
    }
    public static CurrencyPair mapToPairEntity(CurrencyPairDTO dto){
        CurrencyPair entity = new CurrencyPair(dto.getCurrencyBase(),dto.getCurrencyCounter(),dto.getDate(),dto.getValue());
        return entity;
    }
}
