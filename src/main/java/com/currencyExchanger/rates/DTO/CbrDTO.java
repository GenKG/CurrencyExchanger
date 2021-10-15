package com.currencyExchanger.rates.DTO;

import com.currencyExchanger.rates.Util.DateHandler;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CbrDTO {
    @JsonDeserialize(using = DateHandler.class)
    @JsonProperty("Date")
    private Date date;

    @JsonDeserialize(using = DateHandler.class)
    @JsonProperty("PreviousDate")
    private Date previousDate;

    @JsonDeserialize(using = DateHandler.class)
    @JsonProperty("PreviousURL")
    private Date previousURL;

    @JsonDeserialize(using = DateHandler.class)
    @JsonProperty("Timestamp")
    private Date timeStamp;

    public CbrDTO(){}

    public CbrDTO(Date date, Date previousDate, Date previousURL, Date timeStamp, Map<ISO, IsoValue> valute) {
        super();
        this.date = date;
        this.previousDate = previousDate;
        this.previousURL = previousURL;
        this.timeStamp = timeStamp;
        this.valute = valute;
    }

    private Map<ISO,IsoValue> valute = new HashMap<>();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(Date previousDate) {
        this.previousDate = previousDate;
    }

    public Date getPreviousURL() {
        return previousURL;
    }

    public void setPreviousURL(Date previousURL) {
        this.previousURL = previousURL;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
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
