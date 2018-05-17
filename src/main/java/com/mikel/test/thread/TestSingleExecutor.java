/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
-isShutdown() = false         -isShutdown() = true        -isShutdown() = false
-isTerminated() = false       -isTerminated() = false     -isTerminated() = false


 */
public class TestSingleExecutor {
    
    
    public static void main(String[] args) { 
        ExecutorService service = null;
        try{
            //Genera un solo hilo, si ejecuta más de un proceso se quedan en cola
            service = Executors.newSingleThreadExecutor();
            System.out.println("Begin");
            
            //execute(...) ejecuta hilo , no retorna 
            //submit(...) ejecuta hilo , retorna un objeto para analizar el resultado final del hilo
            //se recomienda usar submit sombre execute
            
            //3 principales metodos para ejecutar un hilo   
            //service.execute(Runnable);
            //service.submit(runnable)
            //service.submit(Callable<T>)
            
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
    }
}
