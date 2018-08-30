/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.lambda;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author Miguel
 */
public class TestLambda {
    
    
    
    public static void main(String[] args) {
        
        
        String string = "abc";
        
        Predicate<String> ref = string::startsWith;
        Predicate<String> ref2 = s -> string.startsWith(s);
        BiPredicate<String,String> refa = (s,a)-> s.startsWith(a);
        BiPredicate<String,String> ref2a = String::startsWith;
        
        Predicate<String> ref3 = String::isEmpty;
        Predicate<String> ref4 = s -> string.isEmpty();
        
        System.out.println("ref 3"+ref3.test(""));
        System.out.println("ref 3"+ref4.test("hola"));
        
        List<String> algo;
        
        
    }
    
    public void testLambaCollection(){
        
        Stream<String> algo = Stream.generate( () -> "miaw");
        Predicate<String> predicate = s -> s.length() > 3;
        boolean result = algo.allMatch( predicate);
    }
}
