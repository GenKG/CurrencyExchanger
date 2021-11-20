package com.currencyExchanger.rates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class RatesApplication {

	public static void main(String[] args){
		ApplicationContext context = SpringApplication.run(RatesApplication.class, args);
	}

}
