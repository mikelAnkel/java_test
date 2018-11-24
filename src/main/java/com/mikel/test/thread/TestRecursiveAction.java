/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikel.test.thread;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Miguel
 */
public class TestRecursiveAction {

    /*
        ForkJoinPool >>impl>> AbstractExecutorService >>impl>> ExecutorService
    
    */
    private static final int SEQUENTIAL_THRESHOLD = 5;

    public static void main(String[] args) {
        int[] data = new int[20];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(1000);
            System.out.print(data[i] + " ");
            // Let's print each subarray in a line
            if ((i + 1) % SEQUENTIAL_THRESHOLD == 0) {
                System.out.println();
            }
        }
        ForkJoinPool pool = new ForkJoinPool();
        FindMinimumAction task
                = new FindMinimumAction(data, 0, data.length);
        pool.invoke(task);
    }
}

class FindMinimumAction extends RecursiveAction {
    // A thread can easily handle, let's say, five elements

    private static final int SEQUENTIAL_THRESHOLD = 5;
    // The array with the numbers (we'll pass the same array in
    // every recursive call to avoid creating a lot of arrays)
    private int[] data;
    // The index that tells use where a (sub)task starts
    private int start;
    // The index that tells use where a (sub)task ends
    private int end;

    // Since compute() doesn't take parameters, you have to
    // pass in the task's constructor the data to work
    public FindMinimumAction(int[] data, int start, int end) {
        System.out.println("create new Object:"+start+"-"+end);
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        int length = end - start;
        System.out.println("Obj:"+start+"-"+end+"->leng->"+length);
        if (length <= SEQUENTIAL_THRESHOLD) { // base case
            int min = computeMinimumDirectly();
            System.out.println("Minimum of this subarray: " + min);
        } else { // recursive case
            // Calcuate new subtasks range
            int mid = start + length / 2;
            FindMinimumAction firstSubtask
                    = new FindMinimumAction(data, start, mid);
            FindMinimumAction secondSubtask
                    = new FindMinimumAction(data, mid, end);
            firstSubtask.fork(); // queue the first task
            secondSubtask.compute(); // compute the second task
            firstSubtask.join(); // wait for the first task result
            
        }
    }

    /**
     * Method that find the minimum value
     */
    private int computeMinimumDirectly() {
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }
}
