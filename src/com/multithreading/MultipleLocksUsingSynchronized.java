package com.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleLocksUsingSynchronized {

    Object lock1 = new Object();
    Object lock2 = new Object();

    Random random = new Random();
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    public void stage1 () {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt());
        }
    }
    public void stage2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt());
        }
    }
    public void process() {
        for(int i=0 ; i<100 ; i++) {
            stage1();
            stage2();
        }
    }

    public static void main(String[] args) {
        MultipleLocksUsingSynchronized obj = new MultipleLocksUsingSynchronized();
        Long start = System.currentTimeMillis();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.process();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.process();
            }
        });
        thread1.start();
        t2.start();
        try {
            thread1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Long end = System.currentTimeMillis();
        System.out.println("Process completed in  : " + (end - start));
        System.out.println("Size of List 1 : " + obj.list1.size());
        System.out.println("Size of List 2 : " + obj.list2.size());
    }
}
