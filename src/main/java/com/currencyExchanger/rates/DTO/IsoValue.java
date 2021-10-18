package com.currencyExchanger.rates.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IsoValue {
    @JsonProperty("ID")
    private String id;

    @JsonProperty("NumCode")
    private String numCode;

    @JsonProperty("CharCode")
    private ISO charCode;

    @JsonProperty("Nominal")
    private Integer nominal;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Value")
    private Double value;

    @JsonProperty("Previous")
    private Double previous;

}
