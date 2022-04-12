package com.designpatterns;
import java.util.*;
import java.util.Objects;

abstract class Bill {
    double rate;
    abstract double getBill(double unit);
}

class HomeBill extends Bill {
    double getBill(double unit) {
        return 3.5;
    }
}

class OfficeBill extends Bill {
    double getBill(double unit) {
        return 5.5;
    }
}

class Factory {
    static Bill getBillRate(String place) {
        if(Objects.isNull(place)) {
            return null;
        }
        if(place.equalsIgnoreCase("home")) {
            return new HomeBill();
        } else {
            return new OfficeBill();
        }
    }
}

public class Main {

    public static void main(String[] args) {
	    Bill myBillRate = Factory.getBillRate("home");
        System.out.println(myBillRate.getBill(3.3));
    }
}
