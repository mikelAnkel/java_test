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
public class TestTryCatch implements Closeable {

    private int variable;

    public TestTryCatch(int variable) {
        this.variable = variable;
    }

    @Override
    public void close() throws IOException {
        System.out.println("close !! "+variable);
        //throw new Error(":v - " + variable);
    }

    public static void main(String[] args) {

        //Autocloseable close  throws Exception
        //Closeable extends Autocloseable  close throws IOException
        try {

            try (TestTryCatch test = new TestTryCatch(1);
                    TestTryCatch test2 = new TestTryCatch(2);) {
                System.out.println("test");
                //test = new TestTryCatch(3);//auto-closeable reosurce are final
                throw new IOException("Error throws !!");
            } catch (IOException e) {
                System.out.println("Catch Exception ");
                System.out.println("Error:" + e.getMessage());
                System.out.println("Error2:" + e.getSuppressed()[0].getMessage());
            }
        } catch (RuntimeException e) {
            System.out.println("Catch Exception ");
            System.out.println("Error:" + e.getMessage());
            System.out.println("Error2:" + e.getSuppressed()[0].getMessage());
        }
        

        System.err.println("test m2");
        try {
            m2();
        } catch (Exception e) {
            System.out.println("exception->" + e.getMessage());
            Throwable[] ta = e.getSuppressed();
            for (Throwable t : ta) {
                System.out.println(t.getMessage());
            }
        }
    }

    public static void m1() throws Exception {
        System.out.println("m1 exception");
        throw new Exception("Exception from m1");
    }

    public static void m2() throws Exception {
        try {
            m1();
        } catch (Exception e) {//Can't do much about this exception so rethrow it
            System.out.println("catch an retrown m2");
            throw e;
        } finally {
            System.out.println("call finally runtime exception");
            throw new RuntimeException("Exception from finally");
        }
    }
}
