package com.currencyExchanger.rates.Util;

import com.currencyExchanger.rates.DTO.CurrencyPairDTO;
import com.currencyExchanger.rates.Model.CurrencyPair;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper
public abstract class CurrencyPairMapper {
    public static CurrencyPairMapper INSTANCE = Mappers.getMapper(CurrencyPairMapper.class);

    public abstract CurrencyPair toPojo(CurrencyPairDTO dtoPair);

    public abstract CurrencyPairDTO toDTO(CurrencyPair currencyPair);

    @AfterMapping
    void changeDate(CurrencyPair entity,@MappingTarget CurrencyPairDTO dtoPair) {
        try {
            System.out.println(entity);
            Date format = new SimpleDateFormat("dd-MM-yyyy").parse(entity.getDate().toString());
            System.out.println(format);
            //dtoPair.setDate(format);
        } catch (ParseException e){
            e.printStackTrace();
        }
    }

    public abstract List<CurrencyPairDTO> listToDTO(List<CurrencyPair> pojoPair);

    public abstract List<CurrencyPair> listToPojo(List<CurrencyPairDTO> dtoPair);

}
