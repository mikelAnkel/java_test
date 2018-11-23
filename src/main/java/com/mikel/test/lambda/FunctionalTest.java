/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mikel.test.lambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


/**
 *
 * @author Miguel Angel
 */
public class FunctionalTest {

    
    public static void main(String[] args) {
    
        /*
            Interfaz        Parametros      return      metodo single
            Supplier<T>          ( )          T             get           
            Consumer<T>          (T)         void           accept        
            BiConsumer<T,U>     (T,U)        void           accept        
            Predicate<T>         (T)       boolean          test          
            BiPredicate<T,U>    (T,U)      boolean          test
            Function<T,R>        (T)          R             apply
            BiFunction<T,U,R>   (T,U)         R             apply
            UnaryOperator<T>     (T)          T             apply
            BinaryOperator<T>   (T,T)         T             apply
        
        */

        //Supplier --
        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = ()->LocalDate.now();
        
        Supplier<ArrayList<String>> array_s1 = ArrayList<String>::new; // constructor de referencia
        ArrayList<String> a1 = array_s1.get();
        System.out.println(array_s1);
        System.out.println(a1);
        
        //Consumer
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);
        c1.accept("Mikel");c2.accept("Ankel");//print: Mikel \n Ankel
        
        Map<String,Integer> map = new HashMap<>();
        BiConsumer<String,Integer> b1 = map::put; //referencia a un metodo instanciado !
        
        BiConsumer<String,Integer> b2 = (k,v)-> map.put(k,v);
        b1.accept("a",7 );
        b2.accept("b",2 );
        System.out.println(map); // imprime -> {a=7,b=2}
        
        //Predicate, BiPredicate
        
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();
        System.out.println(p1.test(""));//true
        System.out.println(p2.test(""));//true
        
        BiPredicate<String,String> bp1 = String::startsWith; //compatible
        BiPredicate<String,String> bp2 = (string,prefix) -> string.startsWith(prefix);
        
        System.out.println(bp1.test("chicken", "chick"));
        System.out.println(bp2.test("chicken", "chick"));
        
        //conbinacion predicate
        Predicate<String> egg = s ->s.contains("egg");
        Predicate<String> brown = s ->s.contains("brown");
        Predicate<String> brownEggs = egg.and(brown);
        Predicate<String> otherEggs = egg.and(brown.negate());
        
        //function, BiFunction
        
        Function<String,Integer> f1 = String::length;
        Function<String,Integer> f2 = x -> x.length();
        
        System.out.println(f1.apply("cluck")); // 5
        System.out.println(f2.apply("cluck")); // 5
        
        BiFunction<String,String,String> bf1 = String::concat;
        
        BiFunction<String,String,String> bf2 = (string,toAdd) -> string.concat(toAdd);
        System.out.println(bf1.apply("baby","chick"));;//baby chick
        System.out.println(bf2.apply("baby","chick"));;//baby chick
     
        //Integer.divideUnsigned(0, 0);
    }
}
