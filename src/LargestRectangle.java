import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] prefix = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.offerLast(-1);
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    prefix[j]++;
                } else {
                    prefix[j] = 0;
                }
                while (stack.peekLast() != -1 && prefix[stack.peekLast()] >= prefix[j]) {
                    int height = prefix[stack.pollLast()];
                    int width = j - stack.peekLast() - 1;
                    max = Math.max(max, height * width);
                }
                stack.offer(j);
            }
            while(stack.peekLast() != -1) {
                int height = prefix[stack.pollLast()];
                int width = prefix.length - stack.peekLast() - 1;
                max = Math.max(max, height * width);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangle ins = new LargestRectangle();
        ins.maximalRectangle(new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}});
    }
}
