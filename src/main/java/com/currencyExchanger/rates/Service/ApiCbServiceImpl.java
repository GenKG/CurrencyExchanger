package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.DAO.CurrencyPairRepository;
import com.currencyExchanger.rates.DTO.CbrDTO;
import com.currencyExchanger.rates.DTO.ISO;
import com.currencyExchanger.rates.Model.CurrencyPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import com.currencyExchanger.rates.Model.Currency;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class ApiCbServiceImpl implements ApiCbrService {
    @Value("${cbr.xml.daily.url}")
    private  String urlCbr;

    private  CbrDTO cbrDTO;

    private CurrencyPairRepository repository;

    @Autowired
    public ApiCbServiceImpl(CurrencyPairRepository repository) {
        this.repository = repository;
    }

    private void initCbrDTO()  {
        List<HttpMessageConverter<?>> converter = new ArrayList<>();
        MappingJackson2HttpMessageConverter mappingConverter = new MappingJackson2HttpMessageConverter();
        mappingConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        converter.add(mappingConverter);
        RestTemplate template = new RestTemplate();
        template.setMessageConverters(converter);
        cbrDTO = template.getForObject(urlCbr,CbrDTO.class);
    }

    public Double getValueForPair(Currency base,Currency counter){
        initCbrDTO();
        Double baseValue = cbrDTO.getValute().get(ISO.valueOf(base.getDescription())).getValue();
        Double counterValue = cbrDTO.getValute().get(ISO.valueOf(counter.getDescription())).getValue();
        Double valuePair = Math.round(baseValue/counterValue  * 100.00)/ 100.0;
        saveData(base,counter,cbrDTO.getDate(),valuePair);
        return valuePair;
    }

    //Сохранение полученных данных в базу
    //TODO: необходимо вынести в отдельный класс где будет содержаться вся логика. По SOLID
    private void saveData(Currency base, Currency counter, Date date, Double valuePair){
        CurrencyPair pair = new CurrencyPair(base,counter,date,valuePair);
        repository.save(pair);
    }

}
