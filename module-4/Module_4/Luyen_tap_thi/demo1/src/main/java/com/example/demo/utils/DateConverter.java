package com.example.demo.utils;

//import javax.validation.constraints.NotNull;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class DateConverter implements Converter<String, Date> {



    @Override
    public Date convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date parsedDate = dateFormat.parse(source);
            return new Date(parsedDate.getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd");
        }
    }
}
