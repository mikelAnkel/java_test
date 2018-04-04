/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.files;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Miguel
 */
public class TestDirectoryStream {
 
    public static void main(String[] args) {
        
        //DirectoryStream: recorre un solo nivel si el Path es directorio
        System.out.println("testing Directory Stream");
        Path path = Paths.get("C:\\Users\\Miguel\\");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for (Path element : stream) {
                System.out.println("file name->"+element.getFileName()+" is Directory ->"+Files.isDirectory(path));
            }
        } catch (IOException ex) { ex.printStackTrace(); }
        
        //probando FileVisitor
        //Se usa para visitar todo un arbol de directorios 
        System.out.println("Testing FileVisitor");
        try {
            Files.walk(Paths.get("C:\\Users\\Miguel\\Documents\\respaldo"), 2,FileVisitOption.FOLLOW_LINKS)
                    //.filter(p -> p.getFileName().endsWith("file"))
                    .forEach(p -> System.out.println("Found file: "+p.toAbsolutePath()));
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }                               
    
}
