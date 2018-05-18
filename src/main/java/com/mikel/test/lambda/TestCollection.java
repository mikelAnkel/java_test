/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 *
 * @author Miguel
 */
public class TestCollection {
 
    public static void main(String[] args) {
        
        
    }
    
    public static void testMerge(){
        BiFunction<String,String,String> mapper = (v1,v2)-> v1.length() >v2.length() ? v1:v2;
        Map<String,String> favoritos = new HashMap<>();
        
        favoritos.put("a", "abc");
        favoritos.put("a", "abc");
    }
    
    //Map.putIfAbsent -> coloca el nuevo valor si no existe o si el valor es null
    public static void testMapPutIfAbsent(){
        Map<String,String> favoritos = new HashMap<>();
        favoritos.put("Jenny","a");
        favoritos.put("Tom",null);
        favoritos.putIfAbsent("Jenny","Tram");
        favoritos.putIfAbsent("Sam","Tram");
        favoritos.putIfAbsent("Tom","Tram");
        System.out.println(favoritos);//{Tom=Tram,Jenny=a,Sam=Tram}
    }
    
    //
    public static void testRemoveIf(){
        
        List<String> lista = new ArrayList<>();
        lista.add("Magia");
        lista.add("Armadura");
        System.out.println(lista);//[magia,armadura]
        lista.removeIf( s -> s.startsWith("A"));
        System.out.println(lista);//[magia]
    }
}

