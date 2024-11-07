package Util;

import model.Person.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFurama {
    public static LocalDate changeDateTime(String date){
        LocalDate date1 = null;
        try {
            DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yyyy");
            date1 = LocalDate.parse(date,formatter);
        } catch (Exception e){
            System.out.println("Chuyển đổi không thành công ngày tháng ");
        };

        return date1;
    }

}
