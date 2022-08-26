package com.mslc.training.java.threads.lockingapi.newfeatures;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.TimeZone;

public class DateTimeDemo {

    public static void main(String[] args) {

//        Calendar c = Calendar.getInstance();
//        c.setTimeZone(TimeZone.getTimeZone("ASIA"));

        LocalDate date = LocalDate.now();
        System.out.println(date);
        LocalDateTime ldt0 = LocalDateTime.now();
        System.out.println(ldt0);

        ZonedDateTime zdt0 = ZonedDateTime.now();
        System.out.println(zdt0);

        System.out.println(date.getDayOfWeek());
        LocalDate date2 = LocalDate.of(2024, 7, 6);
        System.out.println(date2.getDayOfWeek());

        LocalDate date3 = LocalDate.parse("2024-07-06");
        System.out.println(date3);

        LocalDate d4 = date3.plusYears(1);
        System.out.println(d4);


        LocalDate d5 = d4.minus(1, ChronoUnit.YEARS);
        System.out.println(d5);

        LocalDateTime startOfTheDay = d4.atStartOfDay();
        System.out.println(startOfTheDay);


        LocalDate londonDate = LocalDate.now(ZoneId.of("Europe/London"));
        System.out.println(londonDate);

        LocalTime londonTime = LocalTime.now(ZoneId.of("Europe/London"));
        System.out.println(londonTime);

        ZoneId.getAvailableZoneIds()
                .forEach(System.out::println);










    }
}
