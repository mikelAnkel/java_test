/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.language;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Miguel
 */
public class TestReadWriteLock {

    public static void main(String[] args) {
        ZooEmployeeNameManager manager = new ZooEmployeeNameManager();
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 100; i++) {
                final int employeeNumber = i;
                service.submit(() -> manager.readNames(employeeNumber));

            }
            service.submit(() -> manager.addName("Grace Hopper"));
            service.submit(() -> manager.addName("Josephine Davis"));
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}

class ZooEmployeeNameManager {

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private List<String> names = new ArrayList<>();

    public ZooEmployeeNameManager() {
        names.add("John Smith");
        names.add("Sarah Smith");
        names.add("James Johnson");
    }

    public String readNames(int i) {
        /*
            Obtiene un lock tipo read, puede dejar otros hilos de tipo read
            ejecutarse simultaneamente excepto un writeLock
        */
        Lock lock = readWriteLock.readLock();
        try {
            lock.lock();
            System.out.println("Read Lock Obtained!");
            return names.get(i % names.size());
        } finally {
            System.out.println("Read Lock Released!");
            lock.unlock();

        }
    }

    public void addName(String name) {
        /*
            writeLock, bloquea cualquier tipo de hilo.
        */
        Lock lock = readWriteLock.writeLock();
        try {
            lock.lock();
            System.out.println("Write Lock Obtained!");
            Thread.sleep(1000);
            names.add(name);
        } catch (InterruptedException e) {          // Handle thread interrupted exception   
        } finally {
            System.out.println("Write Lock Released!");
            lock.unlock();
        }
    }
}
