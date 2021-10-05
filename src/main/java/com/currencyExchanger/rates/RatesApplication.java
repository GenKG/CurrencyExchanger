package com.currencyExchanger.rates;

import com.currencyExchanger.rates.Service.RatesService;
import com.currencyExchanger.rates.controllers.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.text.ParseException;

@SpringBootApplication
public class RatesApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext context = SpringApplication.run(RatesApplication.class, args);
		TestController controller = (TestController) context.getBean(TestController.class);
		controller.rates();
	}

}
