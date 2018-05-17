/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author Miguel
 */
public class TestCheckResult {

    private static int counter= 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
          ExecutorService service = null;
          
        try{
            service = Executors.newSingleThreadExecutor();
            
            Future<?> result = service.submit(()->{
                
                for (int i = 0; i < 500; i++) {
                    TestCheckResult.counter++;
                }
            });
            
            result.get(10, TimeUnit.SECONDS);
            System.out.println("reached");
            
            
        }
        catch(TimeoutException e){
            System.out.println("no rearched in time");
        }
        finally{
            if(service != null){
                service.shutdown();
            }
        }
    }
    
}
