package com.mikel.test.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        //retorna path2 si los paths son absolutos
        
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
            //crea directorio, si el directorio padre no existe, o directorio existente ejecuta error
            Files.createDirectory(path);
            //crea la serie de directorios, si existe ejecuta error
            Files.createDirectories(path);
        } catch (IOException ex) {}
        
        try {
            //Copy
            // Copia archivos(resuelve links), carpetas(ignorando contenido),
            //Defaulqueda en 
            Files.copy(Paths.get(""), Paths.get("")); 
            //error si no se puede copiar o archivos no encontrados
            //rescribe si son directorios al mismo nivel
            //
            Files.move(Paths.get(""), Paths.get("")); 
            
            //error si no existe, no se elimina o tiene subdirectorios/archos
            Files.delete(path);
            
            //si no existe retorna false, error si tiene subdirectorios/archivos
            Files.deleteIfExists(path);
                    
        } catch (IOException ex) {}
        
        try{
            //depth-> cuantos niveles de directorio debe de leer, 0 indica el primer archivo es visitado
            //por default no sige los links
            Files.walk(Paths.get("Path"),10,FileVisitOption.FOLLOW_LINKS).filter( p->p.toString().endsWith(".java")).forEach( System.out::print);
            
            
        }
        catch(Exception e){
            
        }

        // uso de File System.
        Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
        for(Path p : roots){ 
            System.out.println(p); 
        }
        File.listRoots();
        
        
    }
}
