package com.example.quan_ly_ky_tuc.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverter {
    public static Date convertStringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return (Date) dateFormat.parse(dateString);
        } catch (ParseException e) {
            // Xử lý ngoại lệ khi định dạng ngày tháng không hợp lệ
            e.printStackTrace();
            return null;
        }
    }
}
