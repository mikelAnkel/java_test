/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.files;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author Miguel
 */
class TestMyFileChecker extends SimpleFileVisitor<Path> {

    private final PathMatcher matcher;
    private static int count;

    public TestMyFileChecker() {
        matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
    }

    void check(Path p) {
        if (p != null && matcher.matches(p)) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    public FileVisitResult visitFile(Path p, BasicFileAttributes attr) {
        check(p);
        return FileVisitResult.CONTINUE;
    }
}

public class MyFileChecker {

    Integer algo;

    public MyFileChecker() {
        System.out.println("algo->"+algo);
    }
    
        public static void main(String[] args) throws IOException {
        /*
        TestMyFileChecker mfc = new TestMyFileChecker();
        Files.walkFileTree(Paths.get("c:\\works\\pathtest"), mfc);
        System.out.println(mfc.getCount());
*/
          
        new MyFileChecker();
          //System.out.println("algo->"+algo);
    }
}
