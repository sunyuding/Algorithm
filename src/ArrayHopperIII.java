//Description
//        Given an array of non-negative integers,
// you are initially positioned at index 0 of the array.
// A[i] means the maximum jump distance from that position (you can only jump towards the end of the array).
// Determine the minimum number of jumps you need to jump out of the array.
//
//        By jump out, it means you can not stay at the end of the array.
// Return -1 if you can not do so.
//
//        Assumptions
//
//        The given array is not null and has length of at least 1.
//        Examples
//
//        {1, 3, 2, 0, 2},
// the minimum number of jumps needed is 3 (jump to index 1 then to the end of array, then jump out)
//
//        {3, 2, 1, 1, 0},
// you are not able to jump out of array,
// return -1 in this case.
//
//        Medium
//        Greedy
public class ArrayHopperIII {
    public int minJump(int[] array) {
        // state definition
        // dp[i] represents the minimum number of jumps you need to jump out of the subarray(0, i),
        // not including i
        int[] dp = new int[array.length + 1];

        // base case
        // dp[0] = 0
        dp[0] = 0;

        // induction rule
        // for 0 <= j <i
        // A[j] >= i - j, j can jump to i in one step, dp[i] = min of all (dp[j] + 1)
        for (int i = 1; i <= array.length; i++) {
            dp[i] = -1;
            for (int j = 0; j < i; j++) {
                if (array[j] >= i - j) {
                    if (dp[i] == -1) {
                        dp[i] = dp[j] + 1;
                    } else {
                        dp[i] = Math.min(dp[j] + 1, dp[i]);
                    }
                }
            }
            if (dp[i] == -1) {
                //cannot reach i
                return -1;
            }
        }

        // result
        // dp[array.length]
        return dp[array.length];
    }

    public static void main(String[] args) {
        ArrayHopperIII ah = new ArrayHopperIII();

        ah.minJump(new int[]{1});
    }
}
