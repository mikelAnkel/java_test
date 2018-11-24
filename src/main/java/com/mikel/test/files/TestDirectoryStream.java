
package com.mikel.test.files;

import java.io.IOException;
import java.io.UncheckedIOException;
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
        
        //DirectoryStream: recorre un solo nivel del directorio 
        System.out.println("testing Directory Stream");
        Path path = Paths.get("C:\\Users\\Miguel\\");

        //java.nio.file.NotDirectoryException si es file
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            
            for (Path element : stream) {
                System.out.println("file name->"+element.getFileName()+" is Directory ->"+Files.isDirectory(path));
            }
        } catch (IOException ex) { ex.printStackTrace(); }
        
        //probando FileVisitor
        //Se usa para visitar todo un arbol de directorios 
        //soporta 1 archivo como Path
        //Se trunca el recorrido si existe algun error
        //depth-> cuantos niveles de directorio debe de leer, 0 indica el primer archivo es visitado
        //por default no sige los links
        System.out.println("Testing FileVisitor");
        try {
            //Files.walk return Stream<Path>
            Files.walk(Paths.get("C:\\Users\\Miguel\\Documents\\"), 2,FileVisitOption.FOLLOW_LINKS)
                    //.filter(p -> p.getFileName().endsWith("file"))
                    .forEach(p -> System.out.println("Found file: "+p.toAbsolutePath()));
        } 
        catch( UncheckedIOException ex){
            System.out.println("Error ");
           // ex.printStackTrace();
        }
        catch (IOException ex) {
            System.out.println("Error ");
            //ex.printStackTrace();
        }
    }                               
    
}
