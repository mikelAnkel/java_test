/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.functional;

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
        
        
    }

}
