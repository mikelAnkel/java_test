/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.files;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 *
 * @author Miguel Angel
 */
public class TestWatchService {

    /*
        java.nio.file.*
     */
    public static void main(String[] args) throws IOException {

        /*
        Eventos de WatchKey
        Ready: Listo para recibir eventos
        Signaled: uno o mas eventos están encolados.
        Invalid: El evento no es activo, ocurre cuando se llama el metodo cancel,
            El directorio es inaccesible, WatchService es closed
        
        */
        
        try (WatchService service = FileSystems.getDefault().newWatchService();) {
            
            //registro de eventos
            Path zooData = Paths.get("/user/home/zoo/data");
            Path zooLog = Paths.get("/user/home/zoo/log");
            //event count >= 1
            WatchEvent.Kind<?> event0 = StandardWatchEventKinds.OVERFLOW;
            //event count = 1
            WatchEvent.Kind<?> event1 = StandardWatchEventKinds.ENTRY_CREATE;
            //event count = 1
            WatchEvent.Kind<?> event2 = StandardWatchEventKinds.ENTRY_DELETE;
            //event count >=1
            WatchEvent.Kind<?> event3 = StandardWatchEventKinds.ENTRY_MODIFY;
            
            zooData.register(service, StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
            
            zooLog.register(service, StandardWatchEventKinds.ENTRY_MODIFY);
            
            
            for ( ; ;) {
                WatchKey key;
                try{
                    //take espera a que algo suceda dentro del directorio
                    //poll no espera y continua( retorna valores null ), en un ciclo esto puede ser perjudicial
                    key = service.take();
                }
                catch(InterruptedException ex){
                    break ;
                }
                //true si no está cancelado o servicio cerrado
                key.isValid();
                //retrive events for key
                
                for(WatchEvent<?> event: key.pollEvents() ){
                    WatchEvent.Kind<?> kind = event.kind();
                    if( kind == StandardWatchEventKinds.OVERFLOW){
                        continue;
                    }
                    
                    //process event
                    WatchEvent<Path> watchEvent = (WatchEvent<Path>) event;
                    Path path = watchEvent.context();
                    
                    System.out.println("[eventType=]"+kind+", Path="+path.getFileName());
                    
                    //remember ti always reset event key
                    if(!key.reset()){
                        break ;
                    }
                }
                
                
                
                
                
            }
            
            

        }

    }
}
