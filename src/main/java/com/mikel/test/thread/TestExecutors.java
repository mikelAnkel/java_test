/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author Miguel
 */
public class TestExecutors {
    
    
    public static void main(String[] args) {
        //
        
        //usa solo 1 worker thread, ejecuta los hilos como se van llamando
        ExecutorService test = Executors.newSingleThreadExecutor();
        
        //crea un ejcutor simple que administra comandos para correr despues de cierto tiempo o periodo
        ScheduledExecutorService ses1 = Executors.newSingleThreadScheduledExecutor();
        
        //crea un pool de hilos, se van creando conforme se necesiten, puede reusar 
        //hilos previamente contruidos cuando estan disponibles
        ExecutorService test_2 = Executors.newCachedThreadPool();
        
        //crea un set de hilos operados en un shared unbounded queue( cola ilimitada)
        ExecutorService test_3 = Executors.newFixedThreadPool(10);
        
        //crea un pool de hilos que administra runnables con comandos para correr despues de cierto tiempo o periodo
        ScheduledExecutorService ses2 = Executors.newScheduledThreadPool(10);
        
        //obtiene el numero de procesadores de la maquina
        Runtime.getRuntime().availableProcessors();
        
        
        
    }
}
