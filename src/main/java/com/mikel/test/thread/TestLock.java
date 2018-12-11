/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mikel.test.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel Angel
 */
public class TestLock {

    /*
        Tipos de DeadLock
    Starvation: ocurre cuando un hilo bloquea el acceso a un recurso o un lock,
            permanece activo pero no puede completar el trabajo y 
            otros hilos se quedan esperando a acceder al recurso
    LiveLock: ocurre cuando 2 o mas hilos se bloquean entre si 
    */
    
    public static void main(String[] args) {
        //Usa java.util.concurrent.locks.Lock
        //sintaxis
        Lock lock = new ReentrantLock();
        
        //garantiza que el orden de los hilos conforme se van pidiendo
        Lock lock2 = new ReentrantLock(true);
        try{
            lock.lock();
            //...
        }
        finally{ lock.unlock(); }
        //no se puede llamar unlock si no existe un lock antes
        //throws IllegalMonitorStateException at runtime
        
        //trata de obtener inmediatamente un lock, retorna boolean indicando si el lock fue obtenido o no
        if (lock.tryLock() ) lock.unlock();
        
        //incluye un tiempo limite para obtener un lock
        
        try {
            //try lock con limite debe ir con un try
            if (lock.tryLock( 10, TimeUnit.MILLISECONDS)) lock.unlock();
        } catch (InterruptedException ex) {}
        
        //- puede mantener el numero de veces que se ha llamado lock, unlock() debe de llamarse el mismo numero de veces que lock()
        lock.lock();lock.lock();
        //...
        lock.unlock();lock.unlock();
        
    }
}
