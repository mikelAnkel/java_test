package com.mikel.test.files;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestFile {



    public void test(){
        System.out.println("Obteniendo path");

        Path path = Paths.get("C:\\Users\\Anzen\\Documents\\java\\test\\src\\main\\resources\\test.txt");

        //se puede obtener otrs path con el metodo getName ( pos )
        for (int i = 0;i<path.getNameCount();i++){
            System.out.println("element"+i+" is "+path.getName(i));
        }

        //
        Path newSubPath = path.subpath(1,3);
        System.out.println("subpaath->"+newSubPath);

        System.out.println("is Absolute->"+newSubPath.isAbsolute());
        System.out.println("is Absolute->"+newSubPath.getRoot());
    }
}
