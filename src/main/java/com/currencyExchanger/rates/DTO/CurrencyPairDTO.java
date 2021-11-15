package com.currencyExchanger.rates.DTO;

import com.currencyExchanger.rates.Model.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyPairDTO {

    private Long id;

    private Currency base;

    private Currency counter;

    private String date;

    private Double valuePair;
}
