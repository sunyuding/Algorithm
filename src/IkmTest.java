import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Scanner;

public class IkmTest {
//    static class Helper {
//        private int data = 5;
//        public void bump(int inc) {
//            inc++;
//            data = data + inc;
//        }
//    }
    public IkmTest() {
        this(10);
    }

    public IkmTest(int data) {
        this.data = data;
    }

    private int data;

    public static void main(String[] args) {
//        Calendar cal = Calendar.getInstance();
//        cal.set(2000, Calendar.AUGUST, 30);
//        cal.roll(Calendar.MONTH, 7);
//        System.out.println("" + cal.get(Calendar.DATE) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR));
//        cal.add(Calendar.MONTH, 11);
//        System.out.println("" + cal.get(Calendar.DATE) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.YEAR));
//        LocalDate date = LocalDate.of(2000, Month.AUGUST, 30);
//        date.plusMonths(6);
//        System.out.println("" + date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + date.getYear());

//        int j = 0;
//        int a[] = {2, 4};
//        do for (int i : a)
//            System.out.print(i + " ");
//        while (j++ < 1);

//

        int data = 0;
        IkmTest t = new IkmTest();
        t.display();
        System.out.println("data = " + data);
    }

    public void display() {
        class Decrementer {
            public void decrement () {
                data--;
            }
        }
        Decrementer d = new Decrementer();
        d.decrement();
        System.out.println("data = " + data);
    }

}
