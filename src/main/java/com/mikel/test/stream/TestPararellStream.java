/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Miguel
 */
public class TestPararellStream {

    public static void main(String[] args) {
        //como se crean:
        Stream<String> parallelStream = Stream.of("a", "b", "c").parallel();
        //collection 
        List<String> list = Arrays.asList("a", "b", "c");
        Stream<String> parStream = list.parallelStream();
        //ejemplo
        Stream.of("a", "b", "c", "d", "e").forEach(System.out::print);

        System.out.println("Example reduce -----");
        String s = Stream.of("a", "b", "c", "d", "e")
                .parallel()
                .reduce("1", (s1, s2) -> s1 + s2);
        System.out.println("string result->" + s);
        System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6)
                .parallelStream()
                .reduce(0, (a, b) -> {System.out.println("[:"+a+" - "+b+"]"); return a-b;})); // NOT AN ASSOCIATIVE ACCUMULATOR

        int total = IntStream.of(1, 2, 3, 4, 5, 6)
                .parallel()
                
                .reduce(0, (sum, n) -> sum + n);

        System.out.println("total->" + total);

        int length = Stream.of("Parallel", "streams", "are", "great")
                .parallel()
                .reduce(0,
                        (accumInt, str)
                        -> accumInt + str.length(), //accumulator
                        (accumInt1, accumInt2) -> {
                            System.out.println("Conbinando-> " + (accumInt1 + "," + accumInt2));
                            return (accumInt1 + accumInt2);
                        }); //combiner

        System.out.println("result>" + length);
        
        
    }
}
