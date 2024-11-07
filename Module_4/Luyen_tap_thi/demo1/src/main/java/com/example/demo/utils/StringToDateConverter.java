package com.example.demo.utils;


import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
import java.sql.Date;

@Component
public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }

        try {
            long milliseconds = Long.parseLong(source);
            return new Date(milliseconds);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid date format. Please use numeric value representing milliseconds.");
        }
    }
}
