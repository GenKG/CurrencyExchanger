package com.currencyExchanger.rates.DAO;

import com.currencyExchanger.rates.Model.Currency;
import com.currencyExchanger.rates.Model.CurrencyPair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional(readOnly = true)
public interface CurrencyPairRepository extends JpaRepository<CurrencyPair, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE CurrencyPair as cp SET cp.base = :base, cp.counter = :counter, cp.date = :date, cp.valuePair = :value WHERE cp.id = :id")
    boolean update(@Param("base") Currency base,
                   @Param("counter") Currency counter,
                   @Param("date") Date date,
                   @Param("value") Double value,
                   @Param("id") Long id);
    @Transactional
    @Query("SELECT cp.valuePair FROM CurrencyPair as cp where cp.base = :base and cp.counter = :counter and cp.date = :date")
    Double getPairByDate(@Param("base") Currency base,
                         @Param("counter") Currency counter,
                         @Param("date") Date date);
}
