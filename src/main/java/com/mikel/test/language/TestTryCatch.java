/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.language;

import java.io.Closeable;
import java.io.IOException;

/**
 *
 * @author Miguel
 */
public class TestTryCatch implements AutoCloseable {

    private int variable;

    public TestTryCatch(int variable) {
        this.variable = variable;
    }    
    
    @Override
    public void close()  throws IOException {
        throw new Error(":v - "+variable);
    }
    
    
    
    public static void main(String[] args) {
    
        try(TestTryCatch test = new TestTryCatch(1);
                TestTryCatch test2 = new TestTryCatch(2);){
            System.out.println("test");
        }
        catch(Exception e){
            System.out.println("Error:"+ e.getMessage());
            System.out.println("Error2:"+ e.getSuppressed()[0].getMessage());
        }
    }
}
