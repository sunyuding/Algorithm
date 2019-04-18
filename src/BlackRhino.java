class Rhinoceros {
    public Rhinoceros() { System.out.print("1"); }
}

public class BlackRhino extends Rhinoceros {
    public BlackRhino(int age) { System.out.print("2"); }

    public BlackRhino() {

        this(5);

        System.out.print("3");

    }

    public static void main(String[] args) {
        new BlackRhino();
    }
}
