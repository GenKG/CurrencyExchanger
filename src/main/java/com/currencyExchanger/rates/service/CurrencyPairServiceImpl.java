package com.currencyExchanger.rates.service;

import com.currencyExchanger.rates.DAO.CurrencyPairRepository;
import com.currencyExchanger.rates.DTO.CurrencyPairDTO;
import com.currencyExchanger.rates.model.Currency;
import com.currencyExchanger.rates.model.CurrencyPair;
import com.currencyExchanger.rates.util.CurrencyPairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CurrencyPairServiceImpl implements CurrencyPairService {

    private final CurrencyPairRepository repository;
    private final ApiCbServiceImpl cbService;

    @Autowired
    public CurrencyPairServiceImpl(CurrencyPairRepository repository, ApiCbServiceImpl cbService) {
        this.repository = repository;
        this.cbService = cbService;
    }

    @Override
    public List<CurrencyPairDTO> getAll() {
        List<CurrencyPair> pojoPairList = repository.findAll();
        return CurrencyPairMapper.INSTANCE.listToDTO(pojoPairList);
    }

    @Override
    public CurrencyPairDTO getCurrencyPairById(Long id) {
        CurrencyPair pojoPair = repository.findById(id).orElse(null);
        return CurrencyPairMapper.INSTANCE.toDTO(pojoPair);
    }

    @Override
    public CurrencyPairDTO save(CurrencyPair currencyPair) {
        CurrencyPair pojoPair = repository.save(currencyPair);
        return CurrencyPairMapper.INSTANCE.toDTO(pojoPair);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean update(CurrencyPair currencyPair, Long id) {
        return repository.update(currencyPair.getBase(),currencyPair.getCounter(),currencyPair.getDate(),currencyPair.getValuePair(),id);
    }

    @Override
    public Double getPairByDate(Currency base, Currency counter, Date date) {
        Double value = repository.getPairByDate(base,counter,date);
        //Если не находим в базе, то обращаемся к АПИ ЦБ
        if (value == null){
            value = cbService.getValueForPair(base,counter);
        }
        return value;
    }
}
