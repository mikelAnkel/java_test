package com.mikel.test.language;

import java.util.Optional;

public class TestLiterales {


    public static void main(String[] args) {

        //Los numeros por default son asumidos por valor int  (decimal )


        //OCTAL(0-7), usan el 0 como prefijo, ej
        int uno = 01;
        int dos = 02;
        int siete = 07;
        int ocho = 017;
        double d_ocho = 019.92;// no es octal,se considera decimal

        //EXADECIMAL ( 0-9 , A-F) usan prefijo 0x o 0X

        byte exa_uno = 0X1;
        int exa_once = 0xA;
        float exa_quince = 0XF;
        //double exa_double = 0xF.1; no se pueden usar exadecimales double
        System.out.println("exa_dieciseis->"+exa_quince); //imprime en decimal

        //BINARIO (0-1) usa prefijo 0b o OB
        int bin_cero = 0b0;
        int bin_uno = 0B1;
        Integer bin_dos = 0b10;
        double d_dos = 0b100101;
        long x = 0b10000L;
        float xf = 0b10_000;
        //float xf = 0b10_000f;//no valido
        double algo = 10D;
        //double double_bin = 0b10.1;no se puede usar binario tipo double
        System.out.println("bin_cero->"+bin_cero+" , bin_uno->"+bin_uno+" , bin_dos->"+bin_dos);

         //El guon bajo no se puede agregar al inicio o al final de un numero
         //No compilan
         //double a = _1000.00; 
         //double b = 1000.00_; 
         //double c = 1000_.00;
         double d = 1_00__0.0_0; //compila
         
         Optional<Integer> opt = Optional.of(1);
         opt.of(3);
         
         
    }
}
