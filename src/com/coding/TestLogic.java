package com.coding;

import java.util.*;

@FunctionalInterface
interface FuncInterface2 {
    abstract int add(int a, int b);

    public static int doWork() {
        return 1;
    }

}

@FunctionalInterface
interface FuncInterface {
    abstract public int add(int a, int b);

    public static int doWork() {
        return 1;
    }

}
class Me implements FuncInterface, FuncInterface2{

    public int add(int a, int b) {
        return a + b;
    }

}

class Test implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String ob1 = (String) o1;
        String ob2 = (String) o2;
        if(ob1.compareTo(ob2)>0) {
            return 1;
        } else if(ob1.compareTo(ob2)<0) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class TestLogic {
    public static void main(String[] args) {
        Me me = new Me();
        var val = me.add(2,3);
        System.out.println("Value of X : " + val);
        FuncInterface funcInterface = ((a,b) -> {
            return a + b;
        });
        System.out.println("Functional Interface returned : " + FuncInterface.doWork());
        Map<String, String> str = new HashMap<>();
        str.put("a", "test");
        //1
        for (String name : str.keySet())
            System.out.println("key: " + name);
        //2
        for (Map.Entry<String,String> entry : str.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        //3
        str.forEach((x,y)-> {
        System.out.println(x + ":" + y);
        });
        List<String> arr = Arrays.asList("Nikhil","Ankit", "Abhay", "Ketan");
//        String t1 = "Akash";
//        String s2 = "Radha";
//        System.out.println(t1.compareTo(s2));
        Test test = new Test();
        Collections.sort(arr, test);
        arr.stream().forEach(System.out::println);
    }
}
