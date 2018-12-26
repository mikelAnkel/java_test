/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.localization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Miguel
 */
public class TestResourceBundle {
 
    
    public static void main(String[] args) {
        
        Locale locale = new Locale("en", "US");
        ResourceBundle rb = ResourceBundle.getBundle("test.MyBundle", locale);
        rb.getString("key");//MissingResourceException 
        rb.getObject("key");
        rb.getStringArray("key");
        rb.containsKey("key");
        rb.getBaseBundleName();//return test.MyBundle
        rb.keySet();//set<Sintrg>
        rb.getKeys();//Enumeration
        rb.getLocale();
                
        
    }
}
