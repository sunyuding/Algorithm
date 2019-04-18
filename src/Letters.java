public class Letters {
    { System.out.print("a"); }
    public Letters() {
        { System.out.print("b"); }
    }
    { System.out.print("c"); }
    public static void main(String[] args) {
        Letters a = new Letters();
        { System.out.print("d"); }
    }
}
