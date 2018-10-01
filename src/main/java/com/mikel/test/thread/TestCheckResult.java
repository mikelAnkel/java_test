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
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author Miguel
 */
public class TestCheckResult {

    /*        
ExecutorService <- Executors.newSingleThreadExecutor()
Genera un hilo operativo con pila ilimitada

ScheduledExecutorService <- Executors.newSingleThreadScheduledExecutor()
Genera un ejecuter que puede ser ejecutado para corer despues de ciertos intervalos o periodicamente
          
ExecutorService <- Executors.newCachedThreadPool()
Crea un pool de hilos q crean hilos como se van necesitando,
puede reusar hilos ya echos cuando estos están dispinibles
          
ExecutorService <- Executors.newFixedThreadPool(int nThreads)
Crea un grupo de hilos limitados por el parametro nThreads que operan desde una cola compartida
          
ScheduledExecutorService <- SheduledThreadPool(int nThreads)
Crea un grupo de hilos limitados por el parametro nThreads, se operan por comandos para ejecutarse cada
cierto intervalo de tiempo o periodicamente.
          
     */
    private static int counter = 0;

    public static void main(String[] args) {
        try {
            count();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        //use
        beepForAnHour();

    }

    private static void count() throws ExecutionException, InterruptedException {
        ExecutorService service = null;
        ScheduledExecutorService sheduledService = null;

        try {
            service = Executors.newSingleThreadExecutor();

            Future<?> result = service.submit(() -> {

                for (int i = 0; i < 500; i++) {
                    TestCheckResult.counter++;
                }
            });
   
            //result.isDone();   //check if result is sucess
            //result.isCancelled();

            result.get(10, TimeUnit.SECONDS);
            System.out.println("reached");

        } catch (TimeoutException e) {
            System.out.println("no rearched in time");
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }

    private static void beepForAnHour() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(() -> System.out.println("beep"), 10, 10, TimeUnit.SECONDS);
        scheduler.schedule(() -> beeperHandle.cancel(true), 60 * 60, TimeUnit.SECONDS);
    }

}
