package com.currencyExchanger.rates.Service;

import com.currencyExchanger.rates.DTO.CbrDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {
    @Value("${cbr.xml.daily.url}")
    private String urlCbr;

    private ObjectMapper mapper = new ObjectMapper();


    public void getDataForURL() throws JsonProcessingException {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> getEntity = template.getForEntity(urlCbr,String.class);
        CbrDTO data =  mapper.readValue(getEntity.getBody(), CbrDTO.class);
        System.out.println(data.toString());
    }
}
