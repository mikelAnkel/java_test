/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.localization;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class TestNumberFormat {

    public static void main(String[] args) {
        //formato general
        
        //DecimalFormat -> NumberFormat -> Format
        NumberFormat dformat = DecimalFormat.getInstance();
        Format number = DecimalFormat.getInstance();
        NumberFormat format = NumberFormat.getInstance();
        NumberFormat.getInstance(Locale.getDefault());
        NumberFormat.getNumberInstance();//mismo que getInstance
        NumberFormat.getNumberInstance(Locale.getDefault());//mismo que getInstance
        
        
        //para dar formato a montos de dinero
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
        
        //para dar formato a %
        NumberFormat.getPercentInstance();
        
        format.format(19.912); // convertir numero a string
        //parse thows checked ParseException
        try {
            format.parse("10.4545"); //convertir  de string a numero
            String one = "21abc";
            String two = "-19.912x19";
            String tree = "x2313213";
            String amt = "$10.99";
            
            System.out.println( format.parse(one));//21
            System.out.println( format.parse(two));//-19.912
            //System.out.println( format.parse(tree));//throws ParseException
            System.out.println( moneyFormat.parse(amt));//10.99
           // System.out.println( format.parse(amt));//ParseException
            
            
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        
        
        
        
        
    }
    
}
