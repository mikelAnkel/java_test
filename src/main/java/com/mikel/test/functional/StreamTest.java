/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mikel.test.functional;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Miguel Angel
 */
public class StreamTest {

    
    public static void main(String[] args) {
        
        
        
        Stream<Integer>  numeros = Stream.of(5,34,5,3,6,2,65,54);
        long cuenta  = numeros.collect(Collectors.counting());
        System.out.println("cuenta->"+cuenta);        
        
        numeros = Stream.of(5,34,5,3,6,2,65,54);
        Optional<Integer> max = numeros.collect( Collectors.maxBy( Comparator.naturalOrder() ));
        
        
        max.ifPresent(System.out::println);//65 
        testToMap();
        
        
    }
    
    
    private static void testToMap(){
        Stream<String> ohmy = Stream.of("lions","trigers","bears");
        Map<Integer,String> map = ohmy.collect(Collectors.toMap(String::length, k->k, (k,s)->{System.out.println("k->"+k+"|s:"+s);return k+"|"+s;}));
        
        System.out.println(map);
    }
}
