/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.language;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class TestDateFormat {
    
    
    public static void main(String[] args) {
        
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
        
        //Custom date Format
        //M -> Mes  | M -> 1  | MM -> 01   | MMM -> Jan   | MMMM -> January
        //d -> Dia
        //d -> 1  | dd ->01
        //y- Año
        //yy -> 90  | YYYY -> 1990
        //h -> hora
        //m -> minuto
        //s -> Segundo
        
        SimpleDateFormat f1 = new SimpleDateFormat("MM dd yyyy hh:mm:ss");
        SimpleDateFormat f2 = new SimpleDateFormat("MMMM yyyy");
        SimpleDateFormat f3 = new SimpleDateFormat("h");
        
        try {
            Date date = f1.parse("01 26 2016 01:22:33");
            System.out.println("simple date format ----------------");
            System.out.println(f2.format(date));
            System.out.println(f3.format(date));
            
        } catch (ParseException ex) {
         ex.printStackTrace();
        }
        
    }
}


