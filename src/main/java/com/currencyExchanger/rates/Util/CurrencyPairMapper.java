package com.currencyExchanger.rates.Util;

import com.currencyExchanger.rates.DTO.CurrencyPairDTO;
import com.currencyExchanger.rates.Model.CurrencyPair;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CurrencyPairMapper {
    CurrencyPairMapper INSTANCE = Mappers.getMapper(CurrencyPairMapper.class);

    CurrencyPair toPojo(CurrencyPairDTO dtoPair);

    CurrencyPairDTO toDTO(CurrencyPair currencyPair);

    List<CurrencyPairDTO> listToDTO(List<CurrencyPair> pojoPair);

    List<CurrencyPair> listToPojo(List<CurrencyPairDTO> dtoPair);

}
