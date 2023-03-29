package com.currencyExchanger.rates.DTO;

import com.currencyExchanger.rates.Util.DateHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class CbrDTO {

    @JsonDeserialize(using = DateHandler.class)
    @JsonProperty("Date")
    private Date date;

    @JsonDeserialize(using = DateHandler.class)
    @JsonProperty("PreviousDate")
    private Date previousDate;

    @JsonProperty("PreviousURL")
    private String previousURL;

    @JsonDeserialize(using = DateHandler.class)
    @JsonProperty("Timestamp")
    private Date timeStamp;

    @JsonProperty("Valute")
    private Map<ISO,IsoValue> valute = new HashMap<>();

}
