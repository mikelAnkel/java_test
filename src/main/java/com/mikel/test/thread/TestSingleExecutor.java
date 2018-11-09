/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.thread;

import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
/*
 * 
 * 
 * Ciclo de vida de ExecutorService
 
new Executor
    
|--------|     shutdown      |---------------|            |-----------|
| Active |------------------>| Shutting Down |----------->| Shutdown  |   
|--------|                   |---------------|            |-----------|
-Accept new Task              -Reject new Task            -Reject new Task
-Execute Tasks                -Execute Tasks              -No task running
-isShutdown() = false         -isShutdown() = true        -isShutdown() = true
-isTerminated() = false       -isTerminated() = false     -isTerminated() = true


 */
public class TestSingleExecutor {
    
    
    public static void main(String[] args) { 
        
        //soporta solo hilos de tipo Runnable.
        Executor executor = null;
        
        ExecutorService service = null;
        try{
            //Genera un solo hilo, si ejecuta más de un proceso se quedan en cola
            service = Executors.newSingleThreadExecutor();
            System.out.println("Begin");
            
            //execute(...) ejecuta hilo , no retorna 
            //submit(...) ejecuta hilo , retorna un objeto para analizar el resultado final del hilo
            //se recomienda usar submit sombre execute
            
            //3 principales metodos para ejecutar un hilo   
            //Runnable no es checked exception 
            //service.execute(Runnable);
            //service.submit(Runnable)
            //service.submit(Callable<T>)
            
            
            
            //ejecuta todos los hilos callable, todos deben de terminar para continuar (?)
            //List<Future<T>>  service.invokeAll(Collection<? extends Callable<T>> tasks);
            
            //ejecuta al primer hilo, los demas son cancelados
            //T  service.invokeAny(Collection<? extends Callable<T>> tasks);
            
            
            service.execute(()->System.out.println("printing zoo inventory"));
            service.execute(()->
            {
                for (int i = 0; i < 3; i++) {
                    System.out.println("print record->"+i);
                }
            });
            service.execute(()->System.out.println("printing zoo  inventory"));
            System.out.println("end");
        }
        finally{
            if(service!=null){service.shutdown();}
        }
        if(service != null){
            try {
                service.awaitTermination(1, TimeUnit.DAYS);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    //soporta throws Exception on  () -> {throws new Exception();}
    public static void useCallable(Callable<Integer> expresion) {}
}
