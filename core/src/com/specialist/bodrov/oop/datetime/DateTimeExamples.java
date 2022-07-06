package com.specialist.bodrov.oop.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeExamples {

    public static void main(String[] args) {

        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println(instant.toEpochMilli());

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        ZonedDateTime zdt1 = ZonedDateTime.ofInstant(instant,
                ZoneId.of("America/New_York"));

        System.out.println(zdt1);


        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd.MM.yyyy  HH:mm:ssa");

        System.out.println(formatter.format(zdt1));

        LocalDateTime afterOneMonth = localDateTime.plusMonths(1);
        System.out.println(formatter.format(afterOneMonth));

        System.out.println(ChronoUnit.HOURS.between(localDateTime, afterOneMonth));;
        LocalDate date = localDateTime.toLocalDate();
        LocalTime time = localDateTime.toLocalTime();

        System.out.println(date + " " + time);

        Color color = Color.RED;
        System.out.println(color);

    }
}