/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mikel.test.thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Miguel Angel
 */
public class TestAtomic {

    public static void main(String[] args) {
        //atomic clasess
        AtomicBoolean ab = null;
        AtomicInteger ai = null;
        AtomicIntegerArray aia;
        AtomicLong al;
        AtomicLongArray ala;
        AtomicReference ar; 
        AtomicReferenceArray ara;
        
        //commons atomic methods
        
        //ab.get();
        //ab.set(true);
        ab.getAndSet(true);//setea nuevo valor y regresa el antiguo
        ai.incrementAndGet();//++value
        ai.getAndIncrement();//value++
        ai.decrementAndGet();//--value
        ai.getAndDecrement();//value--
        
        
        
        LinkedBlockingQueue blockingQueue = null; //original from
        LinkedBlockingDeque blockingDeque = null;// 
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
}
