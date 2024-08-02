package com.designpatterns;

import java.util.*;

class CheckMultiThread extends Thread{
    @Override
    public void run() {
        try {
            for(int i=0; i<5 ; i++) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Outer {
    static class Inner {
        static int a;
        String b;
        static {
            System.out.println("Static Called");
            a = 9;
        }
    }
}

class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }
}

public class CustomException {
    public static void main(String[] args) {
        System.out.println("--------------------Main Starts---------------------");
        List<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(2);
        number.add(3);
        number.add(4);
        number.add(5);
        int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
        System.out.println("Even value is : " + even);
        CheckMultiThread thread = new CheckMultiThread();
        thread.start();
        try {
            thread.join();
            for(int i=0;i<5;i++) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName());

            }
        } catch (Exception e) {

        }
        Set<String> list = new HashSet();
        list.add("a");
        Map<String, String> map = new HashMap<>();
        list.stream().forEach(x -> {
            System.out.println();
        });
        Outer.Inner in = new Outer.Inner();
        System.out.println(in.a);
        int n = 5;
        System.out.println(Thread.currentThread().getName());
        try {
            if(n==5) {
                throw new MyException("Accepted");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
