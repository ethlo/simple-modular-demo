package com.example.modularproject;

import com.ethlo.time.DateTime;
import com.ethlo.time.DateTimeParser;
import com.ethlo.time.DateTimeTokens;
import com.ethlo.time.Field;
import com.ethlo.time.token.ConfigurableDateTimeParser;
import com.networknt.schema.JsonSchemaFactory;


public class Main {
    public static void main(String[] args) {
        final DateTimeParser yearParser = ConfigurableDateTimeParser.of(DateTimeTokens.digits(Field.YEAR, 4));
        final DateTime result = yearParser.parse("1999");
        System.out.println(result.getMostGranularField());
        final var whatever = new JsonSchemaFactory.Builder().build();
    }
}
