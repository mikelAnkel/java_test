/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.language;

import java.text.DecimalFormat;

/**
 *
 * @author Miguel
 */
public class TestDecimalFormat {


    public static void main(String[] args) {
        //DecimalFormat extends NumberFormat
        
        //# omite la posicion si no existe alg�n d�gito
        //0 coloca un 0 en la posicion si no existe alg�n d�gito
        
        double d = 1234567.437;
        DecimalFormat uno = new DecimalFormat("###,###,###.###");
        DecimalFormat dos = new DecimalFormat("000,000,000.00000");
        DecimalFormat tres = new DecimalFormat("##,###,##,##.####");
        
        System.out.println( uno.format(d) );//1,234,567.437
        System.out.println( dos.format(d) );//001,234,567.43700
        System.out.println( tres.format(d) );//$1,234,567.437
        
    }
}
