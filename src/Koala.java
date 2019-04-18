interface CanClimb {
    int maxHeight();
}
interface HasClaws {
    boolean isSharp();
}
public class Koala implements CanClimb, HasClaws {

    @Override
    public int maxHeight() {
        return 15;
    }

    @Override
    public boolean isSharp() {
        return true;
    }

    public static void main(String args) {
        Object koala = new Koala();
        CanClimb canClimb = (CanClimb) koala;
        HasClaws hasClaws = (HasClaws)canClimb;
        System.out.println(canClimb.maxHeight());
        System.out.println(hasClaws.isSharp());
    }
}
