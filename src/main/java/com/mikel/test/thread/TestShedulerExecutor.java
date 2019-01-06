/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class TestShedulerExecutor {

    public static void main(String[] args) {

        ExecutorService serviceAbs = Executors.newSingleThreadScheduledExecutor();
        //ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        //crea y ejecuta el hilo, despues del delay
        //service.schedule( Callable<T>, 1, TimeUnit.SECONDS)
        //service.schedule(Runnable, 1, TimeUnit.SECONDS);
        //testSimpleShedule();
        //Crea un hilo runnable despues de que pase el tiempo inicial y se crean nuevos hilos acorde al periodo
        //service.scheduleAtFixedRate(Runnable, Long initialDelay, Long period, TimeUnit.SECONDS);
        //ScheduledFuture nunca retorna nada
        ScheduledFuture<?> future2 = service.scheduleWithFixedDelay(()
                -> {
            
            try {
                System.out.println(":V");
                Thread.sleep(1000);
                System.out.println("HOla sleep :V");
            } catch (InterruptedException ex) {
                Logger.getLogger(TestShedulerExecutor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }, 2, 2, TimeUnit.SECONDS);
        //future2.cancel(true);
        service.scheduleWithFixedDelay(() -> {
            System.out.println("HOla :V");
        }, 2, 2, TimeUnit.SECONDS);
        /*
        try{
            System.out.println("antes");
            System.out.println(future2.get(4, TimeUnit.SECONDS));
            System.out.println("despues");
        }
        catch(InterruptedException | ExecutionException |TimeoutException  e){
            
            e.printStackTrace();
        }
         */

        //Crea un hilo runnable despues que pase el tiempo inicial y crea nuevos hilos con el delay entre la terminacion
        //del hilo y el inicio de otro
        //service.scheduleWithFixedDelay(Runnable, Long initialDelay, Long delay, TimeUnit.SECONDS);
    }

    private static void testSimpleShedule() {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> future = service.schedule(() -> {
            System.out.println("HOla :V");
        }, 2, TimeUnit.SECONDS);

        try {
            System.out.println(future.get(1, TimeUnit.SECONDS));

        } catch (InterruptedException | ExecutionException | TimeoutException e) {

            e.printStackTrace();
        }
    }
}
