
package com.mikel.test.localization;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

/**
 *
 * @author Miguel
 */
public class TestDecimalFormat {


    public static void main(String[] args) {
        //DecimalFormat extends NumberFormat
        
        //# omite la posicion si no existe algún dígito
        //0 coloca un 0 en la posicion si no existe algún dígito
        
        double d = 1234567.437;
        DecimalFormat uno = new DecimalFormat("###,###,###.###");
        DecimalFormat dos = new DecimalFormat("000,000,000.00000");
        DecimalFormat tres = new DecimalFormat("$###,###.##");
        
        System.out.println( uno.format(d) );//1,234,567.437
        System.out.println( dos.format(d) );//001,234,567.43700
        System.out.println( tres.format(d) );//$1,234,567.44 <-- si se truncan digitos se redondea !!
        
        
    }
}
