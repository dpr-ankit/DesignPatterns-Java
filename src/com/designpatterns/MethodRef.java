package com.designpatterns;
interface Sayable {
    void say();
}
public class MethodRef {
    public static void saySomething() {
        System.out.println("Said");
    }

    public static void main(String[] args) {
        Sayable say = MethodRef::saySomething;
        System.out.println();
//        Sayable.say();
    }
}
