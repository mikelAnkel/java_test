/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.localization;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 *
 * @author Miguel
 */
public class TestLocation {
 
    public static void main(String[] args) {
        
        //Declaraciones
        Locale locale = Locale.getDefault();
        Locale locate1 = new Locale("fr");
        Locale locate2 = new Locale("hi","IN");
        Locale locate3 = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();
        
        System.out.println( locate2);
        
        //formato en los archivos
        //animal=dolphin
        //animal:dolphin
        //animal dolphin
        //cometarios -> # , !
        //soporta caracteres especiales /n/t
        
        
        Properties p  = new Properties();
        
        System.out.println(p.get("no")); //null
        System.out.println(p.getProperty("no"));//null
        System.out.println(p.getProperty("no","default"));//default
        
        ResourceBundle rb = ResourceBundle.getBundle("test.MyBundle", locale);
        
        //orden de preferencia al buscar un recurso Zoo con Locale: fr_FR o 
        //simplemente "fr" con default locale US
        /**
         * zoo_fr_FR.java
         * zoo_fr.properties
         * zoo_fr.java
         * zoo_fr.properties
         * zoo_en_US.java
         * zoo_en_US.properties
         * zoo_en.java
         * zoo_en.properties
         * zoo.java
         * zoo.properties
         * si no se encuentra lanza MissingResourceException
         * 
         * 
         */
        
    }}

//ejemplo de un recurso por medio de java
//se pueden usar valores que no sean string
//se pueden agregar en tiempo de ejecucion nuevos valores

class test extends ListResourceBundle{

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"hola","hi"},
            {"abrir","open"}
        };
    }
    
    
}
