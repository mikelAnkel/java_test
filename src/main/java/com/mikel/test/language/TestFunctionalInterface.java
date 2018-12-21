/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.language;

import java.lang.AutoCloseable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class TestFunctionalInterface {

    //contiene solo 1 metodo abstracto
    //una iterface puede redeclarar un metodo default y volverlo abstract 
    //o redeclararlo
    
    public static void main(String[] args) {
        Account variable = new FinalAccount();
        String algo = FinalAccount.getIda();
        String algo2 = PremiumAccount.getIda();

        String algo3 = Account.test();

        variable.getId();
        
;
    }   
}

interface Account {

    public default String getId() {
        return "0000";
    }
    static String test(){ return "XD"; }
}

interface PremiumAccount extends Account {
    static String getIda(){ return "1111"; }
    
    public default void test(){
        System.out.println("test");
    }
}

class FinalAccount implements PremiumAccount{

    static String getIda(){ return "1111"; }
    
    public void hola(){
        
    }
}
