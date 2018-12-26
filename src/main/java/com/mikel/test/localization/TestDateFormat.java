/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.localization;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;



/**
 *
 * @author Miguel
 */
public class TestDateFormat {
    /*
        DateFormat usa Date
    
        DateTimeFormatter usa LocalTime,LocalDate,LocalDateTime
    
    */
    
    public static void main(String[] args) {
        
        
        Date calendar = Calendar.getInstance(Locale.US).getTime();
        
        //LocalDate: no time, no timeZone
        //LocalTime: no date no timeZone
        //LocalDateTime: no timeZone
        //ZonedDateTime: contains date,time and timezone
        
        //year, month(1-12), dayofMonth(1-31)
        LocalDate.of(1990, 1, 1);
        
        //year, enum Month, dayofMonth(1-31)
        LocalDate.of(1990, Month.JANUARY, 1);
        
        Integer hour = 0;
        Integer minute = 1;
        Integer second = 1;
        Integer nanos = 1;
        LocalTime.of(hour, minute);
        LocalTime.of(hour, minute,second);
        LocalTime.of(hour, minute,second,nanos);
        
        
        //inicializaciones
        //DateTimeException -> RuntimeException
        LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.MARCH, 6, 12, 30);
        LocalDateTime dateTime2 = LocalDateTime.of( LocalDate.of(1990, 1, 1),  LocalTime.of(hour, minute));
        //LocalDateTime dateTime3 = LocalDateTime.parse("2015-01-01 2:00:00");
        
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);// 2018-01-20
        //las operaciones retornan un nuevo LocalDate
        localDate = localDate.plusDays(0);
        localDate = localDate.plusMonths(0);
        localDate =localDate.plusWeeks(0);
        localDate = localDate.plusYears(0);
        
        //DateFormat -------------------------------------------------
        //da formato a fechas con formatos predetermnados
        DateFormat s = DateFormat.getDateInstance(DateFormat.SHORT);
        DateFormat m = DateFormat.getDateInstance(DateFormat.MEDIUM);
        DateFormat l = DateFormat.getDateInstance(DateFormat.LONG);
        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
        
        Date d = new GregorianCalendar(2015, Calendar.JULY, 4).getTime();
        
        System.out.println(s.format(d));//4/07/15
        System.out.println(m.format(d));//4/07/2015
        System.out.println(l.format(d));//4 de julio de 2015
        System.out.println(f.format(d));//sábado 4 de julio de 2015
        
        System.err.println("");
        DateFormat dtf = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.FULL);
        DateFormat dtf2 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
        DateFormat dtf3 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.FULL,Locale.GERMAN);
        
        System.out.println( dtf.format(d) );//4/07/2015 12:00:00 AM CDT
        System.out.println( dtf2.format(d) );//sábado 4 de julio de 2015 12:00:00 AM CDT
        System.out.println( dtf3.format(d) );//04.07.2015 00:00 Uhr CDT
        
        
        
        //Solo acepta de tipo Date
        //IllegalArgumentException: Cannot format given Object as a Date
        //System.out.println( dtf3.format( LocalTime.now() ) );
        
        //Custom date Format
        //M -> Mes  | M -> 1  | MM -> 01   | MMM -> Jan   | MMMM -> January
        //d -> Dia
        //d -> 1  | dd ->01
        //D ->1 365 dia del año
        //y- Año
        //yy -> 90  | YYYY -> 1990
        //h -> hora
        //H ->Hora en dia de 0-23
        //m -> minuto
        //s -> Segundo
        //S ->milisegundos
        //z ->Time zone
        
        //SimpleDateFormat   --------------------------------------------
        //acepta tipo Date
        //da formato a fechas con formato personalizado
        SimpleDateFormat f1 = new SimpleDateFormat("MM dd yyyy hh:mm:ss");
        SimpleDateFormat f2 = new SimpleDateFormat("MMMM yyyy");
        SimpleDateFormat f3 = new SimpleDateFormat("h");
        
        try {
            Date date = f1.parse("01 26 2016 01:22:33");
            System.out.println("simple date format ----------------");
            
            
            System.out.println(f2.format(date));//enero 2016
            System.out.println(f3.format(date));//1
            
        } catch (ParseException ex) {
         ex.printStackTrace();
        }
        
        //DateTimeFormatter ---------------- no soporta de tipo Date
        
        //dar formato con las mismas clases de localDate,LocalTime,LocalDateTime
        //con ayuda de DateTimeFormatter
        //LocalTime
        //DateTimeFormatter.ISO_TIME;
        
        //locaDate
        //DateTimeFormatter.ISO_DATE;
        
        LocalDateTime dateTime = LocalDateTime.now();
        String dateTimeFormated = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        
        //dar formato con DateTimeFormatter
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        
        formatter1.format(dateTime);
        //ofLocalizedDateTime solo soporta dar formato a LocalDateTime y ZoneDateTime
        //..Date no soporta dar formato a LocalTime
        //..Time no soporta dar formato a LocalDate
        
        //
        System.out.println("test DateTimeFormatter");
        DateTimeFormatter dtf1_loc = DateTimeFormatter.ofPattern("yy/mm/dd",Locale.ENGLISH);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yy/mm/dd");
        LocalDateTime ldt = LocalDateTime.of(2015,10,10,11,22);
        LocalTime algo = LocalTime.now();
        System.out.println(dtf1.format( ldt ));
        //UnsupportedTemporalTypeException: Unsupported field: DayOfMonth
        //String ltf = algo.format( DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        String ltf = algo.format( DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        System.out.println("localTimeFormat->"+ltf);
        //
            
    }
}


