/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.thread;

import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Miguel
 */
public class TestConcurrentCollection {
    
    public static void main(String[] args) {
        testCopyOnWriteArrayList();
    }

    public static void testCopyOnWriteArrayList() {

        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int i = it.next();
            System.out.print(i + " ");
            // No exception thrown
            list.set(list.size() - 1, i * 10);
            // it.remove(); throws an exception
        }
        System.out.println(list);
        
        int algo = 10__0;
    }
}
