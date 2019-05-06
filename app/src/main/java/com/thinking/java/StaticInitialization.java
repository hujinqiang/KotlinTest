package com.thinking.java;


import static com.thinking.java.PrintUtilKt.printS;

class Bowl{
    Bowl(int marker){
        printS("Bowl(" + marker +")");
    }
    void f1(int marker){
        printS("f1(" + marker + ")");
    }
}

class Table{
    static Bowl bowl1 = new Bowl(1);
    Table(){
        printS("Table()");
        bowl2.f1(1);
    }

    void f2(int marker){
        printS("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);
}

class Cupboard{
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    public Cupboard() {
        printS("Cupboard()");
        bowl4.f1(2);
    }

    void f3(int marker){
        printS("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5);
}

public class StaticInitialization {
    public static void main(String[] args) {
        printS("Creating new Cupboard() in main");
        new Cupboard();
        printS("Creating new Cupboard() in main");
        new Cupboard();

        table.f2(1);
        cupboard.f3(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
