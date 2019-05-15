package test;


import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

class Test{
//    public static int[ ] getArray() {  return null;  }
//    public static void main(String[] args) {
//        int index = 1;
//        try {
//            getArray()[index = 2]++;
//        } catch (Exception e) {
//
//        }  //empty catch
//        System.out.println("index = " + index);
//    }
    @interface MyAnno{}

    public static void main(String[] args) {
        Predicate<String> lengther = (s -> s.length() < 2);
        Predicate<String> equlizer = Predicate.isEqual("car");
        Function<Boolean, String> booleaner = i -> Boolean.toString(i);
        Function<String, Boolean> stringer = s -> Boolean.parseBoolean(s);
//        System.out.println(booleaner.compose(stringer).apply("true").substring(0, 3));
//        System.out.println(stringer.compose(booleaner).apply(true));
//        System.out.println(booleaner.andThen(stringer).apply("true"));
        System.out.println(lengther.negate().or(equlizer).test("CAR"));
        System.out.println(booleaner.apply(true));

    }
}