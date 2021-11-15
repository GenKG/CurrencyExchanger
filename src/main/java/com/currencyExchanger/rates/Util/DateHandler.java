package com.currencyExchanger.rates.Util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHandler extends StdDeserializer<Date>
{

    public DateHandler(){
        this(null);
    }

    public DateHandler(Class<?> clazz){
        super(clazz);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String date = jsonParser.getText();
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
            return format.parse(date);
        } catch (ParseException e){
           throw new RuntimeException(e);
        }
    }
}
