/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Miguel
 */
public class CyclicBarrierTest {
    
    private void remove( ){
        System.out.println("remove");
    }
    private void clean( ){
        System.out.println("clean");
    }
    private void add( ){
        System.out.println("add");
    }
    
    public void performTask(CyclicBarrier c1,CyclicBarrier c2){
        try{
            remove();
            c1.await();
            clean();
            c2.await();
            add();
                    
        }
        catch( InterruptedException | BrokenBarrierException e){
            ;
        } 
    }
    
    public static void main(String[] args) {
        ExecutorService service = null;
        try{
            service = Executors.newFixedThreadPool(4);
             CyclicBarrierTest manager = new CyclicBarrierTest();
             CyclicBarrier barrier1 = new CyclicBarrier(4);
             CyclicBarrier barrier2 = new CyclicBarrier(4,()-> System.out.println("Clean complete !!"));
             for (int i = 0; i < 4; i++) {
                service.submit( ()-> manager.performTask(barrier1, barrier2));
            }
        }
        finally{
            if( service != null) service.shutdown();
        }
    }
    
}
