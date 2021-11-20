package com.currencyExchanger.rates.Controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "apiCB", url = "${cbr.xml.daily.baseUrl}")
public interface CbClient  {

    @GetMapping(value = "${cbr.xmd.daily.allValue}",consumes = MediaType.APPLICATION_JSON_VALUE)
    String getAllCbValue();
}
