package com.example.modularproject;

import com.ethlo.chronograph.Chronograph;
import com.ethlo.chronograph.OutputConfig;
import com.ethlo.chronograph.output.table.TableOutputFormatter;
import com.ethlo.chronograph.output.table.TableThemes;
import com.ethlo.time.DateTime;
import com.ethlo.time.DateTimeParser;
import com.ethlo.time.DateTimeTokens;
import com.ethlo.time.Field;
import com.ethlo.time.token.ConfigurableDateTimeParser;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {

        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012, builder ->
                builder.schemaMappers(schemaMappers -> schemaMappers.mapPrefix("https://www.example.org/", "classpath:schema/"))
        );

        final Chronograph chronograph = Chronograph.create();

        final int runs = 100_000;
        final DateTimeParser yearParser = ConfigurableDateTimeParser.of(DateTimeTokens.digits(Field.YEAR, 4));
        final List<DateTime> results = new ArrayList<>(runs);
        IntStream.rangeClosed(1, runs).forEach(i ->
                chronograph.time("parse", () ->
                {
                    final DateTime result = yearParser.parse("1999");
                    results.add(result);
                }));

        System.out.println(results.size());
        System.out.println(new TableOutputFormatter(TableThemes.OCEAN_BREEZE, OutputConfig.EXTENDED).format(chronograph.getTaskData()));
    }
}
