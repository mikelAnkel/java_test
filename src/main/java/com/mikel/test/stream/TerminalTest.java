/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author Miguel Angel
 */
public class TerminalTest {

    public static void main(String[] args) {
        testMin();
    }

    private static void testMin() {
        Stream<String> s = Stream.of("monkey", "ape", "bobono", "miawaaw", "eeee");

        Optional<String> min = s.min((s1, s2) -> {
            System.out.println("comparando (" + s1 + "," + s2 + ") result:" + (s1.length() - s2.length()));
            return (s1.length() - s2.length());
        });
        min.ifPresent(System.out::println);//ape

        List<String> al = Arrays.asList("aa", "aaa", "b", "cc", "ccc", "ddd", "a");
        
        float count = al.stream().filter((str) -> str.compareTo("c") < 0).count();//Count retorna Long

        
        //lISTA DE METODOS TERMINALES
        //<R, A> R collect(Collector<? super T, A, R> collector);
        //<R> R collect(Supplier<R> supplier,BiConsumer<R, ? super T> accumulator,
        //                  BiConsumer<R, R> combiner);
        //long count();
        //T reduce(T identity, BinaryOperator<T> accumulator);
        //Optional<T> reduce(BinaryOperator<T> accumulator);
        
        //combiner funciona cuando es streamPararell
        //<U> U reduce(U identity,
        //                BiFunction<U, ? super T, U> accumulator,
        //                BinaryOperator<U> combiner);
        
        //void forEach(Consumer<? super T> action);
        //forza imprimirlos en orden cuando se usa pararell
        //void forEachOrdered(Consumer<? super T> action);
        //Optional<T> min(Comparator<? super T> comparator);
        //Optional<T> max(Comparator<? super T> comparator);
        //boolean anyMatch(Predicate<? super T> predicate);
        //boolean allMatch(Predicate<? super T> predicate);
        //boolean noneMatch(Predicate<? super T> predicate);
        //Optional<T> findAny();
        //Optional<T> findFirst();
        
        //Considerados reduccion
        //Collect()
        //count()
        //min()/max() 
        //reduce
        
        //double sum = 0;
        //error: local variable must be final
        //al.stream().forEach(a->{ sum=sum+a; });
    }

}
