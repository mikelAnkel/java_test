/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.localization;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Miguel
 */
public class TestPeriod {
    
    
    public static void main(String[] args) {
        
        //Periodo se usa para fechas 
        LocalDate date =  LocalDate.now();
        
        System.out.println(date);//2018-10-26
        LocalDate dateTest = LocalDate.parse("2007-12-03");

        LocalDate dateFormat =  LocalDate.parse("2015-01-01");

        
        Period period = Period.ofMonths(1);
        System.out.println( Period.of(0, 20, 47));//P20M47D
        
        Period.of(1,2,3);//anio , mes dia
        //P1Y2M3D
        
        
        //duration se usa para fechas por hora Formato      // PT0H0M0S
        Duration daily = Duration.ofDays(1);                // PT24H
        Duration hourly = Duration.ofHours(1);              // PT1H 
        Duration everyMinute = Duration.ofMinutes(1);       // PT1M 
        Duration everyTenSeconds = Duration.ofSeconds(10);  // PT10S 
        Duration everyMilli = Duration.ofMillis(1);         // PT0.001S 
        Duration everyNano = Duration.ofNanos(1);           // PT0.000000001S
        
        System.out.println("2 dias :"+Duration.ofDays(2));
        
       LocalDate date1 = LocalDate.of(2015,1,20);
       LocalTime time1 = LocalTime.of(6, 15);
       LocalDateTime dateTime = LocalDateTime.of(date1,time1);
       Period period1 = Period.ofMonths(1);
       
        System.out.println( date.plus(period1));// ok
        System.out.println( dateTime.plus(period1)); //ok
        //System.out.println( time1.plus(period1)); // UnsopportedTemporalTypeException
        
        
        LocalTime one = LocalTime.of(5, 15);
        LocalTime two = LocalTime.of(6, 30);
        LocalTime localTimeParsed_1 =LocalTime.parse("10:15:30"); 
        //LocalTime localTimeParsed_2 =LocalTime.parse("25:15.30"); // could not be parsed: Invalid value for HourOfDay 
       
        System.out.println(ChronoUnit.HOURS.between(one, two));//1
        System.out.println(ChronoUnit.MINUTES.between(one, two));//75
        System.out.println(ChronoUnit.HOURS.between(two, one));//-1
        System.out.println( Duration.between(two, one));//PT-1H-15M
        
        //java.time.temporal.UnsupportedTemporalTypeException
        //System.out.println(ChronoUnit.DAYS.between(one, two));
        
        Period p = Period.between(LocalDate.now(), LocalDate.of(2015, Month.SEPTEMBER, 1));
        System.out.println("perdiod->"+p);//P-3Y-3M-5D es negativo
         
        //instant: un punto en el tiempo en GTM zone
        Instant now = Instant.now();
        System.out.println(now);//2015-05-25T15:15:00Z
        
        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zoned = ZonedDateTime.now(zoneId);
        zoned.toInstant();//convert to Instant
        //LocalDateTime,LocalDate no support convert to Instant.
        
       String m1 = Duration.of(1, ChronoUnit.MINUTES).toString();
       String m2 = Duration.ofMinutes(1).toString();
       
        System.out.println("m1->"+m1);
        System.out.println("m2->"+m2);
        System.out.println("equals ?->"+(m1 == m2));


    }
}
