package com.designpatterns;

import java.util.HashMap;
import java.util.Map;

public class Implment {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "ankit");
        map.put("surname", "yadav");
        for(Map.Entry<String, String> a : map.entrySet()) {
            System.out.println(a.getKey());
            System.out.println(a.getValue());
        }
    }
}
