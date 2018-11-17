/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Miguel
 */
public class TestShedulerExecutor {
 
    
    public static void main(String[] args) {
        
        
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        
        
        //crea y ejecuta el hilo, despues del delay
        //service.schedule( Callable<T>, 1, TimeUnit.SECONDS)
        //service.schedule(Runnable, 1, TimeUnit.SECONDS);
        
        //Crea un hilo runnable despues de que pase el tiempo inicial y se crean nuevos hilos acorde al periodo
        //service.scheduleAtFixedRate(Runnable, Long initialDelay, Long period, TimeUnit.SECONDS);
        
        //Crea un hilo runnable despues que pase el tiempo inicial y crea nuevos hilos con el delay entre la terminacion
        //del hilo y el inicio de otro
        //service.scheduleAtFixedDelay(Runnable, Long initialDelay, Long delay, TimeUnit.SECONDS);
        
        
    }
}
