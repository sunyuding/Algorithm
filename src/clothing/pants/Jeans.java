package clothing.pants;

import clothing.Shirt;

public class Jeans {
    public void matchShirt () {
        String color = Shirt.getColor();
        if (color.equals("Green")) {
            System.out.println("Fit");
        }

    }
}
