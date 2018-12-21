/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
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
        Runnable r = TestLambda::new;
        System.out.println("test print runable");
        Runnable run = TestLambda::print2;
         
        
         Consumer<String> consumer =  TestLambda::testConsumer;
         
         testOperator();
    }
    //las lambas que retornan void soportan aquellos metodos que retornan  algun dato
    public static String testConsumer(String param) {
        System.err.println("param");
        return "";
    }
    
    public static void print2() {
        
        System.out.println("print 2");
    }
    
    public static Runnable print() {
        
        System.out.println("calling print here :v ");
         return () -> {
             System.out.println("Hi");
         };
     }
    
    public static void testLambaCollection(){
        
        Stream<String> algo = Stream.generate( () -> "miaw");
        Predicate<String> predicate = s -> s.length() > 3;
        boolean result = algo.allMatch( predicate);
    }
    
    
    public static void testOperator(){
        String val1 = "hello";
        List<String> list = new ArrayList<>();
        list.add("list");
        StringBuilder val2 = new StringBuilder("world");
        UnaryOperator<String> uo1 = s1->s1.concat(list.get(0)); //1
        UnaryOperator<String> uo2 = s->s.toUpperCase(); //2
        //System.out.println(uo1.apply(uo2.apply(val2))); //3
        test(list, uo1);
    }
    
    public static void test(List<String> val, UnaryOperator<String> uo1){
        val.set(0, "helow");
        String result = uo1.apply(" mundo");
        System.out.println("result->"+result);
        PlaceHolder<String,Integer> placeHolder= new PlaceHolder<>("hola",4);
        PlaceHolder.getDuplicateHolder(placeHolder);
        
    }
      
}

class PlaceHolder<K, V> { //1
    private K k;     private V v;
    public PlaceHolder(K k, V v){ //2         
   this.k = k;         this.v = v;     } 
    public K getK() { return k; } 
    public static <X> PlaceHolder<X, X> getDuplicateHolder(X x){ //3  
        return new PlaceHolder<X, X>(x, x); //4
    }
} 
