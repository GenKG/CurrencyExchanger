package com.currencyExchanger.rates;

import com.currencyExchanger.rates.controllers.CurrencyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.text.ParseException;

@SpringBootApplication
public class RatesApplication {

	public static void main(String[] args){
		ApplicationContext context = SpringApplication.run(RatesApplication.class, args);
	}

}
