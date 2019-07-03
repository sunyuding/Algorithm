package test;

public class B extends A{
    int i = 4;
    public static void main(String[] args) {
        A a = new B();
        a.print();
    }
    void print() {
        System.out.println(i);
    }
}
