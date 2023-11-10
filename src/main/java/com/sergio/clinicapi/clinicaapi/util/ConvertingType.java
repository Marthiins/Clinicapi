package com.sergio.clinicapi.clinicaapi.util;

import com.sergio.clinicapi.clinicaapi.enumerated.WorkDayEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConvertingType {

    public ConvertingType() {
    }

    public static LocalDate toLocalDateBrazilFormat(String date) {
        if (date != null) {
            return LocalDate.parse(date, brazilFormat());
        }
        return null;
    }

    private static String brazilFormat(LocalDate date) {
        return date.format(brazilFormat());
    }


    public static WorkDayEnum getWeekDayByLocalDate(LocalDate dataConsulta) {
        return WorkDayEnum.valueOf(dataConsulta.getDayOfWeek().toString());
    }

    private static DateTimeFormatter brazilFormat() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
}
