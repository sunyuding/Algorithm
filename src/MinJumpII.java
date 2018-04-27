public class MinJumpII {

    public static int minJump(int[] array) {
        // Write your solution here
        // dp[i] represent the minimum steps from 0-th element to the i-th element
        // base case: dp[0] = 0
        // induction rules: dp[i] = dp[j] + 1, j < i and from j-th element 1 step to i-th element
        // result: dp[array.length - 1]
        int[] dp = new int[array.length];
        dp[0] = 0;
        for (int i = 1; i < array.length; i++) {
            dp[i] = -1;
            for (int j = 0; j < i; j++) {
                if (array[j] >= i - j && dp[j] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[j] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[array.length - 1];
    }

    public static void main(String[] args) {
        // 0 1 2 3 4
        // 2 3 1 1 4
        //       i
        //         j
        int[] array = new int[] {4,2,1,2,0,0};
        int num = minJump(array);
        System.out.println(num);
    }
}
