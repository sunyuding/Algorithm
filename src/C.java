public class C {
    String seq = "c";
    { seq += "g"; }
    public C() {
        this("abc");
        seq += "y";
    }

    public C(String s) {
        seq += "e";
    }

    { seq += "z"; }

    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.seq);
    }
}
