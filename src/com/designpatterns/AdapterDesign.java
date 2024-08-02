package com.designpatterns;

class PilotPen {
    public void mark(String m) {
        System.out.println(m);
    }
}

class PenAdapter implements Pen {
    PilotPen pp = new PilotPen();
    public void write(String str) {
        pp.mark(str);
    }
}

interface Pen {
    void write(String str);
}

class AssignmentWork {
    private Pen p;
    public Pen getP() {
        return p;
    }
    public void setP(Pen p) {
        this.p = p;
    }
    public void writeAssignment(String str) {
        p.write(str);
    }
}

public class AdapterDesign {
    public static void main(String[] args) {
        Pen p = new PenAdapter();
        AssignmentWork awk = new AssignmentWork();
        awk.setP(p);
        awk.writeAssignment("Tired to write an assignment!");
    }
}
