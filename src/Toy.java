class Toy {
    private boolean containsIce = false;

    public boolean containsIce() {
        return containsIce;
    }

    public void removeIce() {
        this.containsIce = true;
    }

    public static class Otter {
        private static void play(Toy toy) {
            toy.removeIce();
        }
    }

    public static void main(String[] args) {
        Toy toy = new Toy();
        Otter.play(toy);
        System.out.println(toy.containsIce());
    }
}
