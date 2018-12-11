/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.files;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;


/**
 *
 * @author Miguel Angel
 */
public class TestFileVisitor {

    public static void main(String[] args) throws Exception {
        //Path, Set<FileVisitOption> deph, classVisitor
        //Files.walkFileTree(start, options, 0, visitor)
        //not follow symbolic links by default
        //soporta 1 archivo (?)
        ///si depth es 0 solo visita el primer archivo o folder
        Files.walkFileTree(Paths.get("C:\\Users\\Anzen\\Documents\\framework\\test"), new FindAndCopyFile());

        //SimpleFileVisitor lanza exception y detiene el proceso en el arbol llamando visitFileFailed
    }

}

class FindAndCopyFile implements FileVisitor<Path> {

    /*
        FileVisitResult.CONTINUE    ->  continua al siguiente archivo
        FileVisitResult.TERMINATE;  ->  termina inmediatamente el analisis
        FileVisitResult.SKIP_SUBTREE->  usado en preVisitDirectory() indica que el directorio actual y sus hijos van a ser omitidos
        FileVisitResult.SKIP_SIBLINGS-> usado en preVisitDirectory() y postVisitDirectory() indica que todos los hermanos que no se han visitado se van a omitir
                                        si es usado en preVisitDirectory() indica que todo el directorio será omitido
     */
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("preVisitDirectory->"+dir);
        if(dir.toString().contains("test1-1 - copia")){
            System.out.println("se va hacer un SKIP_SIBLINGS");
            return FileVisitResult.SKIP_SIBLINGS;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("visitFile ->"+file);
        if (file.getFileName().equals("Zoo.txt")) {
            Files.copy(file, Paths.get("zoo2.txt"));

            return FileVisitResult.TERMINATE;
        } else {
            return FileVisitResult.CONTINUE;
        }
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("postVisitDirectory->"+dir);
        
        if(dir.toString().contains("test2-1 - copia (2)")){
            System.out.println("se va hacer un SKIP_SIBLINGS");
            return FileVisitResult.SKIP_SIBLINGS;
        }
        return FileVisitResult.CONTINUE;
    }

}
