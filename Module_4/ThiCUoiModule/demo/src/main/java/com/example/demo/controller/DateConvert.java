package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConvert {
    public static java.sql.Date convertStringToSQLDate(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            java.util.Date utilDate = sdf.parse(dateStr);
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
