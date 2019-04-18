interface CanSwim {
    public static int SPEED = 1;
    public void swim();
}

public class MantaRay implements CanSwim {

    @Override
    public void swim() {
        System.out.println(SPEED);
    }
}
