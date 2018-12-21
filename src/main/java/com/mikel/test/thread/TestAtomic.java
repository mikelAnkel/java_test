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
        ai.addAndGet(0);//agrega y retorna
        //actualiza solo si expected es igual al valor actual de la clase
        ai.compareAndSet(1, 10);//expected,updated
        
        ai.getAndAdd(0);
        
        
        
        
      
        
        
        
    }
}
