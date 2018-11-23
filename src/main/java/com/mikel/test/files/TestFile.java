package com.mikel.test.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestFile {

   

    public static void main(String[] args){
        System.out.println("Obteniendo path");
        
        Path path = Paths.get("C:\\Users\\Anzen\\Documents\\java\\test\\src\\main\\resources\\test.txt");
        //lo mismo 
        //    ->     FileSystems.getDefault().getPath(("/url/"));
        
        //se puede obtener otrs path con el metodo getName ( pos )
        for (int i = 0;i<path.getNameCount();i++){
            System.out.println("element"+i+" is "+path.getName(i));
        }

        //
        Path newSubPath = path.subpath(1,3);//inicia del indice 0
        System.out.println("subpaath->"+newSubPath); //Anzen\Documents
        //absolito-> debe de iniciar con  letra (ej: c:// , d://) o / 
        System.out.println("is Absolute->"+newSubPath.isAbsolute()); // false
        System.out.println("get root->"+newSubPath.getRoot()); // null
        
        //Path Relativize
        Path pathR1 = Paths.get("a.txt");
        Path pathR2 = Paths.get("b.txt");
        pathR1.relativize(pathR2);//  ..\b.txt
        pathR2.relativize(pathR1);//  ..\a.txt
        //los 2 deben de ser ambos relativos o ambos absolutos
        //deben de estar en la misma unidad, en el caso de windows
        
        //resolve 
        //path1.resolve(path2)
        //regresa un nuevo path uniendo a los 2 paths, solo si es relativo
        //retorna path2 si los paths son absolutos (?)
        System.out.println("Resolve---");
        Path doc1 = Paths.get("C:\\Program Files");
        Path doc2 = Paths.get("otro_folder/test.sd");
        Path doc3 = Paths.get("folder/other.sdf");
        
        //C:\Users\Anzen\Documents\git\java_test\test
        
        System.out.println(doc1.resolve(doc2));//abs+rel = abs/rel
        System.out.println(doc2.resolve(doc1));////rel+abs = abs
        System.out.println(doc2.toAbsolutePath().resolve(doc1));//abs1+abs2 = abs2
        System.out.println(doc1.resolve(doc2.toAbsolutePath()));//abs2+abs1 = abs2
        System.out.println(doc2.resolve(doc3));//rel+rel = rel/rel
        System.out.println(doc3.resolve(doc2));//rel+rel = rel/rel
        System.out.println("end ---");
        
        //normalize
        path.normalize();
        //limpia un path,  elimina . ../, 
        // -> /foo -> /foo
        //-> //foo -> /foo
        //-> foo/ -> /foo
        //->foo/bar -> /foo/bar
        //->foo/bar/../baz -> /foo/baz
        //->foo//bar -> /foo/bar
        
        
        try {
            //crea directorio,error si padre no existe, o directorio existente 
            Files.createDirectory(path);
            //crea la serie de directorios, si existe ejecuta error
            Files.createDirectories(path);
        } catch (IOException ex) {}
        
        try {
            //Copy
            // Copia archivos(resuelve links), carpetas(ignorando contenido),
            Files.copy(Paths.get(""), Paths.get("")); 
            
            //error si no se puede copiar o archivos no encontrados
            //rescribe si son directorios al mismo nivel
            Files.move(Paths.get(""), Paths.get("")); 
            
            //error si no existe, no se elimina o tiene subdirectorios/archos
            Files.delete(path);
            
            //si no existe retorna false, error si tiene subdirectorios/archivos
            Files.deleteIfExists(path);
                    
        } catch (IOException ex) {}
        

        // uso de File System.
        //obtiene todos los Paths de Root
        Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
        for(Path p : roots){ 
            System.out.println(p); 
        }
        //obtiene todos los archivos de root
        File.listRoots(); // return File[]
        
        
        
    }
}
