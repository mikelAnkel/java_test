/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.thread;

import java.nio.file.Files;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Miguel
 */
public class TestConcurrentCollection {

    public static void main(String[] args) {
        testCopyOnWriteArrayList();
    }

    public static void testMap() {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("elephant", 10);
        System.out.println(map.get("elephant"));
        
        
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(31);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        
        Deque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.offer(10);
        deque.push(4);
        
        System.out.println(deque.peek());
        System.out.println(deque.pop());

    }

    public static void testBlocking() {
    /*
        LinkedBlockingQueue
            ->BlockingQueue
                ->Queue
        
        */
        
        LinkedBlockingQueue blockingQueue = null; //original from
        LinkedBlockingDeque blockingDeque = null;// 
        

        Integer ab = 0;
        try {
            //nuevos metodos
            blockingQueue.offer(ab, 10, TimeUnit.SECONDS);//agrega un nuevo objeto al queue, esperando cierto tiempo,                           //
            blockingQueue.poll(1, TimeUnit.SECONDS);//recupera y elimina el item del queue, esperando el tiempo especificado

            blockingDeque.offerFirst(ab, 10, TimeUnit.DAYS); //agrega item al inicio del queue, esperando el tiempo especificado
            blockingDeque.offerLast(ab, 0, TimeUnit.DAYS);//agrega item al final del queue, esperando el tiempo especificado como limite para aregarlo
            blockingDeque.pollFirst(0, TimeUnit.DAYS);// recuera y elimina el primer item del queue, esperando tiempo limite para hacerlo
            blockingDeque.pollLast(0, TimeUnit.DAYS);// recuera y elimina el ultimo item del queue, esperando tiempo limite para hacerlo

        } catch (InterruptedException ex) {
            ;
        }
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

    }
}
