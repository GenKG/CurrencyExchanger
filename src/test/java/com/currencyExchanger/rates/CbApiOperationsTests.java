package com.currencyExchanger.rates;

import com.currencyExchanger.rates.DAO.CurrencyPairRepository;
import com.currencyExchanger.rates.Model.Currency;
import com.currencyExchanger.rates.Model.CurrencyPair;
import com.currencyExchanger.rates.Service.CbApiOperations;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CbApiOperationsTests {
    private static CurrencyPair currencyPairTest;
    @Mock
    private CurrencyPairRepository currencyPairRepository;
    private CbApiOperations apiOperations;

    @BeforeClass
    public static void prepareTestData() {
        currencyPairTest = new CurrencyPair();
        currencyPairTest.setValuePair(25.00);
        currencyPairTest.setBase(Currency.USD);
        currencyPairTest.setCounter(Currency.EUR);
        currencyPairTest.setDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
    }

    @Before
    public void init() {
        apiOperations = new CbApiOperations(currencyPairRepository);
    }

    @Test
    public void saveNewCurrencyPairTest() {
        when(currencyPairRepository.save(any(CurrencyPair.class))).thenReturn(currencyPairTest);
        CurrencyPair savedPair = apiOperations.saveNewValuePair(currencyPairTest.getBase(), currencyPairTest.getCounter(), currencyPairTest.getDate(), currencyPairTest.getValuePair());

        assertNotNull(savedPair);
        MatcherAssert.assertThat(savedPair.getBase(), Matchers.equalTo(currencyPairTest.getBase()));
        MatcherAssert.assertThat(savedPair.getCounter(), Matchers.equalTo(currencyPairTest.getCounter()));
        assertEquals(savedPair.getValuePair(), currencyPairTest.getValuePair());
        assertEquals(savedPair.getDate(), currencyPairTest.getDate());
    }

}
