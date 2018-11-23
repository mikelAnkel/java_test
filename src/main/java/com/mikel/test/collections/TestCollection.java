/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author Miguel
 */
public class TestCollection {
 
    public static void main(String[] args) {
        
        testMerge();
        
        //List:
        // replaceAll(UnaryOperator<E> o) // reemplaza todos los valores por otros nuevos
        //list.forEach(consumer<U> | BiConsumer<U,V>) //sirve para realizar accion a cada valor de la lista/map
        
        ConcurrentMap<String,Object> algo = new ConcurrentHashMap<>();
        
        
        
    }
    
    public static void computeIfPresent(){
        
        Map<String,Integer> couts = new HashMap<>();
        //setea y retorna el valor del resultado de BiFunction , null si no existe key
        Integer result = couts.computeIfPresent("Jenny", (k,v)-> v+1);
        
        
        Integer result2 = couts.computeIfAbsent("Tom", (k) -> 1);
        
    }
    
    public static void testMerge(){
        BiFunction<String,String,String> mapper = (v1,v2)-> v1.length() >v2.length() ? v1:v2;
        Map<String,String> favoritos = new HashMap<>();
        
        favoritos.put("a", "abc");
        favoritos.put("b", "pepes");
        //si no existe el valor o es null se setea automaticamente
        //si existe el valor se setea dependiendo el valor que regresa la validaccion de biFunction
        //si mapper retorna null se elimina el valor de map
        String result = favoritos.merge("a", "ac", mapper); 
        String result2 = favoritos.merge("b","pepesito", mapper);

        System.out.println(favoritos);// {a=abc, b=pepesito}
        System.out.println(result);// abc
        System.out.println(result2);// pepesito
    }
    
    ////setea el valor , solo si key NO existe o si el valor es null
    public static void testMapPutIfAbsent(){
        Map<String,String> favoritos = new HashMap<>();
        favoritos.put("Jenny","a");
        favoritos.put("Tom",null);
        favoritos.putIfAbsent("Jenny","Tram");
        favoritos.putIfAbsent("Sam","Tram");
        favoritos.putIfAbsent("Tom","Tram");
        
        System.out.println(favoritos);//{Tom=Tram,Jenny=a,Sam=Tram}
    }
    
    
    //remueve elemento si predicate es true.
    //remove if ( predicate<> )
    public static void testRemoveIf(){
        
        List<String> lista = new ArrayList<>();
        lista.add("Magia");
        lista.add("Armadura");
        System.out.println(lista);//[magia,armadura]
        boolean sucess = lista.removeIf( s -> s.startsWith("A"));
        
        System.out.println(lista);//[magia]
    }
}

