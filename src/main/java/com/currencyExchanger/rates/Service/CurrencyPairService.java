package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.DTO.CurrencyPairDTO;
import com.currencyExchanger.rates.Model.Currency;
import com.currencyExchanger.rates.Model.CurrencyPair;

import java.util.Date;
import java.util.List;

public interface CurrencyPairService {
    List<CurrencyPairDTO> getAll();

    CurrencyPairDTO getCurrencyPairById(Long id);

    CurrencyPairDTO save(CurrencyPair currencyPair);

    void delete(Long id);

    boolean update(CurrencyPair currencyPair, Long id);

    Double getPairByDate(Currency base, Currency counter, Date date);
}
