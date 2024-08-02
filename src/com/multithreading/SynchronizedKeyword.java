package com.multithreading;

public class SynchronizedKeyword {
    Integer c = 0;
    public static void main(String[] args) {
        SynchronizedKeyword obj = new SynchronizedKeyword();
        obj.doWork();
    }
    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    c++;
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    c++;
                }
            }
        });
        t1.start();
        t2.start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(c);
    }
}
