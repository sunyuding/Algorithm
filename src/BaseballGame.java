import java.util.ArrayDeque;
import java.util.Deque;

public class BaseballGame {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        int num = 0;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                num = stack.pollFirst();
                sum -= num;
            } else if (ops[i].equals("D")) {
                num = 2 * stack.peekFirst();
                stack.offerFirst(num);
                sum += num;
            } else if (ops[i].equals("+")) {
                int b = stack.pollFirst();// 10
                int a = stack.peekFirst();// 5
                num = a + b;// 15
                stack.offerFirst(b);
                stack.offerFirst(num);
                sum += num;
            } else {
                num = Integer.parseInt(ops[i]);
                stack.offerFirst(num);
                sum += num;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        BaseballGame ins = new BaseballGame();
        ins.calPoints(new String[] {"5","-2","4","C","D","9","+","+"});
    }
}
