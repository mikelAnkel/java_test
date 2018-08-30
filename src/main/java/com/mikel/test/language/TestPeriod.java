/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.language;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Miguel
 */
public class TestPeriod {
    
    
    public static void main(String[] args) {
        
        //Periodo se usa para fechas 
        LocalDate date =  LocalDate.now();
        Period period = Period.ofMonths(1);
        
        Period.of(1,2,3);//anio , mes dia
        //P1Y2M3D
        
        
        //duration se usa para fechas por hora Formato      // PT0H0M0S
        Duration daily = Duration.ofDays(1);                // PT24H
        Duration hourly = Duration.ofHours(1);              // PT1H 
        Duration everyMinute = Duration.ofMinutes(1);       // PT1M 
        Duration everyTenSeconds = Duration.ofSeconds(10);  // PT10S 
        Duration everyMilli = Duration.ofMillis(1);         // PT0.001S 
        Duration everyNano = Duration.ofNanos(1);           // PT0.000000001S
        
        
       LocalDate date1 = LocalDate.of(2015,1,20);
       LocalTime time1 = LocalTime.of(6, 15);
       LocalDateTime dateTime = LocalDateTime.of(date1,time1);
       Period period1 = Period.ofMonths(1);
       
        System.out.println( date.plus(period1));// ok
        System.out.println( dateTime.plus(period1)); //ok
        System.out.println( time1.plus(period1)); // UnsopportedTemporalTypeException
        
        
        LocalTime one = LocalTime.of(5, 15);
        LocalTime two = LocalTime.of(6, 30);
       
        System.out.println(ChronoUnit.HOURS.between(one, two));//1
        System.out.println(ChronoUnit.MINUTES.between(one, two));//75
        System.out.println(ChronoUnit.HOURS.between(one, two));//DateTimeException
        
        
       


    }
}