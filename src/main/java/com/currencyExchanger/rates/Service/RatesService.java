package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.Config.JDBCPostgreSQLConnect;
import com.currencyExchanger.rates.DAO.CurrencyPairDAO;
import com.currencyExchanger.rates.DTO.CurrencyPairDTO;
import com.currencyExchanger.rates.Model.Currency;
import com.currencyExchanger.rates.Model.CurrencyPair;
import com.currencyExchanger.rates.Util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RatesService {
    private CurrencyPairDAO dao;

    @Autowired
    public RatesService(CurrencyPairDAO dao) {
        this.dao = dao;
    }

    public List<CurrencyPair> getAllRates(Integer rateSize){
        List<CurrencyPair> listPair = new ArrayList<>();
        for (int i = 0; i < rateSize;i++){
            listPair.add(new CurrencyPair(RandomEnum.randomEnum(Currency.class),
                    RandomEnum.randomEnum(Currency.class),
                    RandomDate.getRandomDate(),
                    RandomValue.randomDoubleValue(1000.00,0.0001,100.00)
                    ));
        }
       return listPair;
    }

    public void streamMap(){
        List<CurrencyPair> currencyPairs = getAllRates(30);
        System.out.println("---------------------------------");
        System.out.println("this stream sorts by date");
        currencyPairs.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("---------------------------------");
        System.out.println("this stream sorts by currency");
        currencyPairs.stream()
                .sorted((o1, o2) -> new CurrencyPairComparator().compare(o1,o2))
                .forEach(System.out::println);
        System.out.println("---------------------------------");
        System.out.println("this stream sorts by value");
        currencyPairs
                .stream()
                .sorted(new CurrencyPairValueComparator().reversed())
                .limit(5)
                .forEach(System.out::println);
    }

    public void allSQLQuery(){
        JDBCPostgreSQLConnect.connection();
        System.out.println("get all CurrencyPair");
        System.out.println("-----------------------");
        dao.getAll().forEach(System.out::println);
        System.out.println("-----------------------");
        System.out.println("Get dto by id: " + dao.getDTOById(5).toString());
        System.out.println("-----------------------");
        CurrencyPairDTO dto = new CurrencyPairDTO();
    }

    public CurrencyPair getPojo(CurrencyPair entity) {
        CurrencyPairDTO dto= dao.getDTOByDTO(MappingUtils.mapToPairDTO(entity));
        System.out.println(MappingUtils.mapToPairEntity(dto));
        return MappingUtils.mapToPairEntity(dto);
    }

}
