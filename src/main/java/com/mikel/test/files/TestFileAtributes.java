/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class TestFileAtributes {

    public static void main(String[] args) {
        Path path_modified = Paths.get("test.txt");
        try {
            System.out.println(Files.getLastModifiedTime(path_modified).toMillis());

            Files.setLastModifiedTime(path_modified, FileTime.fromMillis(System.currentTimeMillis()));

        } catch (IOException ex) {

        }

        try {    // Read owner of 
            Path path = Paths.get("/chicken/feathers.txt");
            System.out.println(Files.getOwner(path).getName());// Change owner of file    
            UserPrincipal owner = path.getFileSystem()
                    .getUserPrincipalLookupService().lookupPrincipalByName("jane");
            Files.setOwner(path, owner);// Output the updated owner information
            System.out.println(Files.getOwner(path).getName());
        } catch (IOException e) {
            // Handle file I/O exception... 
        } catch (Exception e) {

        }
        //Files.setAttribute(path_modified, attribute, args, options)  throws IOException
        //the attribute parameter identifies the attribute to be set and takes the form: [view-name:]attribute-name 
        
            
        //DosFileAttributeView
        /*
        readonly  Boolean  
hidden  Boolean  
system  Boolean  
archive  Boolean 
         */
        
 /*
BasicFileAttributeView

"lastModifiedTime"  FileTime  
"lastAccessTime"  FileTime  
"creationTime"  FileTime  
"size"  Long  
"isRegularFile"  Boolean  
"isDirectory"  Boolean  
"isSymbolicLink"  Boolean  
"isOther"  Boolean  
"fileKey"  Object  
         */
    }

}
