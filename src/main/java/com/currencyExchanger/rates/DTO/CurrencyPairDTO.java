package com.currencyExchanger.rates.DTO;

import com.currencyExchanger.rates.Model.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyPairDTO {

    private Long id;

    private Currency base;

    private Currency counter;

    private Date date;

    private Double valuePair;
}
