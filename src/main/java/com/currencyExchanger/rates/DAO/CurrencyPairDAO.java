package com.currencyExchanger.rates.DAO;

import com.currencyExchanger.rates.Model.Currency;
import com.currencyExchanger.rates.Model.CurrencyPair;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CurrencyPairDAO extends ControllerDAO<CurrencyPair, Integer> {
    public static final String SELECT_ALL_CURRENCY_PAIR = "SELECT * FROM SCHEMA.CURRENCY_PAIR";

    @Override
    public List<CurrencyPair> getAll() {
        List<CurrencyPair> listPairs = new LinkedList<>();
       PreparedStatement ps =  getPrepareStatement(SELECT_ALL_CURRENCY_PAIR);
       try {
           ResultSet rs = ps.executeQuery();
           while (rs.next()){
            CurrencyPair currencyPair = new CurrencyPair(
                    Currency.valueOf(rs.getString(1)),
                    Currency.valueOf(rs.getString(2)),
                    rs.getDate(3),
                    rs.getDouble(4));
            listPairs.add(currencyPair);
           }
       } catch (SQLException e){
           e.printStackTrace();
       } finally {
           closePrepareStatement(ps);
       }
       return listPairs;
    }

    @Override
    public CurrencyPair update(CurrencyPair entity) {
        return null;
    }

    @Override
    public CurrencyPair getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(CurrencyPair entity) {
        return false;
    }
}
