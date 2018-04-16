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
        
     */
    public static void main(String[] args) throws IOException {

        try (WatchService service = FileSystems.getDefault().newWatchService();) {
            
            //registro de eventos
            Path zooData = Paths.get("/user/home/zoo/data");
            Path zooLog = Paths.get("/user/home/zoo/log");
            
            zooData.register(service, StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE,StandardWatchEventKinds.ENTRY_MODIFY);
            zooLog.register(service, StandardWatchEventKinds.ENTRY_MODIFY);
            
            
            for ( ; ;) {
                WatchKey key;
                try{
                    //take espera a que algo suceda dentro del directorio
                    //poll no espera y continua, en un ciclo esto puede ser perjudicial
                    key = service.take();
                }
                catch(InterruptedException ex){
                    break ;
                }
                
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
                }
                
                
                
                
                
            }
            
            

        }

    }
}
