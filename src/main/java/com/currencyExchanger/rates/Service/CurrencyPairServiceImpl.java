package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.DAO.CurrencyPairRepository;
import com.currencyExchanger.rates.Model.CurrencyPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CurrencyPairServiceImpl implements CurrencyPairService {

    private final CurrencyPairRepository repository;

    @Autowired
    public CurrencyPairServiceImpl(CurrencyPairRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CurrencyPair> getAll() {
        return repository.findAll();
    }

    @Override
    public CurrencyPair getCurrencyPairById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public CurrencyPair save(CurrencyPair currencyPair) {
        return repository.save(currencyPair);
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
