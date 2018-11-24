/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mikel.test.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
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

        max.ifPresent(System.out::print);
        System.out.println();
        System.out.println("---------------");
        
        System.out.println("max->"+ Integer.max(5, 4));
        System.out.println("compare->"+ Integer.compare(5, 4));
        List<Integer> ls = Arrays.asList(3,4,6,9,2,5,7);
        System.out.println(ls.stream().reduce(Integer.MIN_VALUE, (a, b)->a>b?a:b)); //1 
        System.out.println(ls.stream().max(Integer::max).get()); //2
        System.out.println(ls.stream().max(Integer::compare).get()); //3
        System.out.println(ls.stream().max((a, b)->a>b?a:b)); //4
        
        
        Optional<Integer> op =ls.stream().max( (a,b)->a-b);
        //manda error: NoSuchElementException, si no existe ningun valor
        System.err.println( op.get() );

        max.ifPresent(System.out::println);//65 
        testToMap();
        
        
    }
    
    
    private static void testToMap(){
        Stream<String> ohmy = Stream.of("lions","trigers","bears");
        //simple
        //Error: IllegateStateException : Duplicate keys
        Map<Integer,String> map1 = ohmy.collect(Collectors.toMap(String::length, k->k));
        
        //complex (Key Value, value, en caso de key duplicada que hacer con los 3 valores)
        Map<Integer,String> map2 = ohmy.collect(Collectors.toMap(String::length, k->k, (k,s)->{System.out.println("k->"+k+"|s:"+s);return k+"|"+s;}));
        
        TreeMap<Integer,String> map3 = ohmy.collect(Collectors.toMap(String::length, k->k, (k,s)->{System.out.println("k->"+k+"|s:"+s);return k+"|"+s;},TreeMap::new));
    }
    
    private static void testGropingBy(){
        //test Stream To Map simple 
        Stream<String> ohmy = Stream.of("lions","trigers","bears");
        Map<Integer, List<String> > map = ohmy.collect(Collectors.groupingBy(String::length));
        //map: {5=[Lion,bears], 6=[trigers]}
        
        
        //test partitioning
        Stream<String> ohmy1 = Stream.of("lions","trigers","bears");
        Map<Boolean, List<String> > map1 = ohmy.collect(Collectors.partitioningBy(s -> s.length()>7));
        //{false:[], true :[lions,trigers,bears] }
        
        
        
       
    }
    
}
