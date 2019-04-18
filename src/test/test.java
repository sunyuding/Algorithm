package test;


class Test{
    public static int[ ] getArray() {  return null;  }
    public static void main(String[] args) {
        int index = 1;
        try {
            getArray()[index = 2]++;
        } catch (Exception e) {

        }  //empty catch
        System.out.println("index = " + index);
    }}