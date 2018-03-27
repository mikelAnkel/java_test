/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.files;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class TestDirectoryStream {
 
    public static void main(String[] args) {
        
        //DirectoryStream: recorre un solo nivel si el Path es directorio
        Path path = Paths.get("C:\\Users\\Miguel\\NTUSER.dat");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
            for (Path element : stream) {
                System.out.println("file name->"+element.getFileName()+" is Directory ->"+Files.isDirectory(path));
            }
        } catch (IOException ex) { ex.printStackTrace(); }
    }
}
