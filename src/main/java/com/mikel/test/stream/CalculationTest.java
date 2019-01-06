/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Miguel
 */
public class CalculationTest {
    
    
    public static void main(String[] args) {
        
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6);
        IntStream.of(1,2,3);//no soportan list
        numeros.stream().count(); //long count()
        //Optional<T> max(Comparator<? super T> comparator)
        //Optional<T> min(Comparator<? super T> comparator)
        
        //IntStream  --------------------------
        //OptionalDouble average()
        //long count()
        //OptionalInt max()
        //OptionalInt min()
        //int sum()
        
        //LongStream   ----------------
//        OptionalDouble average()
//        long count()
//        OptionalLong max()
//        OptionalLong min()
//        long sum()

        //DoubleStream
//        OptionalDouble average()
//        long count()
//        OptionalDobule max()
//        OptionalDouble min()
//        double sum()

            IntStream is = IntStream.rangeClosed(1, 4);
        is.flatMap((a) -> IntStream.of(a));
        OptionalInt sum = is.reduce((a, b)->a+b);
        int suma = is.reduce(0,(a, b)->a+b);
        System.out.println(sum.getAsInt());
    }
}
