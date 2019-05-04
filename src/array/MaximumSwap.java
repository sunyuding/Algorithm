package array;
//
// Given a non-negative integer,
// you could swap two digits at most once to get the maximum valued number.
// Return the maximum valued number you could get.
//
//        Example 1:
//        Input: 2736
//        sort:  2367
//        Output: 7236
//        Explanation: Swap the number 2 and the number 7.
//        Example 2:
//        Input: 9973
//        Output: 9973
//        Explanation: No swap.
//        Note:
//        The given number is in the range [0, 10 ^ 8]
//
public class MaximumSwap {
    // 98368
    //  s
    //   f
    //  m
    //
    /**
     * Brute Force
     * Time: O(n ^ 2)
     * Runtime: 0 ms
     * Memory Usage: 31.8 MB
     * Space: O(1)
     * @param num
     * @return
     */
//    public int maximumSwap(int num) {
//        String s = String.valueOf(num);
//        char[] array = s.toCharArray();
//        int slow = 0;
//        while(slow < array.length) {
//            int fast = slow + 1;
//            int maxIndex = slow;
//            // find maxIndex for slow
//            while (fast < array.length) {
//                if (array[fast] - '0' >= array[maxIndex] - '0') {
//                    maxIndex = fast;
//                }
//                fast++;
//            }
//            // if the current element on slow is the max from slow to right,
//            // do not need to update
//            if (array[maxIndex] != array[slow]) {
//                char tmp = array[slow];
//                array[slow] = array[maxIndex];
//                array[maxIndex] = tmp;
//                break;
//            }
//            slow++;
//        }
//        return Integer.parseInt(new String(array));
//    }

    /**
     *
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] array = s.toCharArray();
        int[] dict = new int[10];
        //O(n)
        for (int i = 0; i < array.length; i++) {
            dict[array[i] - '0']++;
        }

        return Integer.parseInt(new String(array));
    }
}
