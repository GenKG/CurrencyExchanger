package com.currencyExchanger.rates.Model;

import com.currencyExchanger.rates.Util.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@Table(name = "currency_pair",schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public  class CurrencyPair  implements Comparable<CurrencyPair> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "currency_base")
    @Enumerated(EnumType.STRING)
    private  Currency base;

    @Column(name = "currency_counter")
    @Enumerated(EnumType.STRING)
    private  Currency counter;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd Z", timezone="America/New_York")
    @JsonSerialize(using = CustomDateSerializer.class)
    @Column(name = "date")
    private  Date date;
    
    @Column(name = "value")
    private  Double valuePair;

    @Override
    public int compareTo(CurrencyPair o) {
        if (o.date.getTime() > this.date.getTime())
            return -1;
        else if (o.date.getTime() < this.date.getTime()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
