/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.language;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class TestDiamon {
 
    public static void main(String[] args) {
        //error
        //List<Object> list= new ArrayList<String>();
        
        List<? extends Shape> strList = new ArrayList<>();
        List<Shape> listShape = new ArrayList<>();
        
        //strList.add(new Shape());//Error
        listShape.add(new Shape());//ok
    }
    
    public List<? extends Shape> m4(List<? extends Shape> strList){
        List<Shape> list = new ArrayList<>();
        list.add(new Shape());
        list.addAll(strList);
        return list;
    } 
}

class Shape {
    
}