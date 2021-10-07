package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.DAO.CurrencyPairRepository;
import com.currencyExchanger.rates.DTO.CurrencyPairDTO;
import com.currencyExchanger.rates.Model.CurrencyPair;
import com.currencyExchanger.rates.Util.CurrencyPairMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyPairServiceImpl implements CurrencyPairService {

    private final CurrencyPairRepository repository;

    @Autowired
    public CurrencyPairServiceImpl(CurrencyPairRepository repository) {
        this.repository = repository;
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
}
