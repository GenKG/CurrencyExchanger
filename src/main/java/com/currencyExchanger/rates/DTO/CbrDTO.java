package com.currencyExchanger.rates.DTO;

import com.currencyExchanger.rates.Util.DateHandler;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ToString
public class CbrDTO {

    @Getter
    @Setter
    @JsonDeserialize(using = DateHandler.class)
    @JsonProperty("Date")
    private Date date;

    @Getter
    @Setter
    @JsonDeserialize(using = DateHandler.class)
    @JsonProperty("PreviousDate")
    private Date previousDate;

    @Getter
    @Setter
    @JsonProperty("PreviousURL")
    private String previousURL;

    @Getter
    @Setter
    @JsonDeserialize(using = DateHandler.class)
    @JsonProperty("Timestamp")
    private Date timeStamp;

    @JsonProperty("Valute")
    private Map<ISO,IsoValue> valute = new HashMap<>();

    @JsonAnyGetter
    public Map<ISO, IsoValue> getValute() {
        return valute;
    }

    @JsonAnySetter
    public void setValute(Object eventObject) {
        if(eventObject instanceof Map){
            this.valute.putAll((Map<ISO, IsoValue>) eventObject);
        }
    }

}
