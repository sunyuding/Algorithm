package array;

import java.util.Arrays;

//Given an array consists of non-negative integers,
// your task is to count the number of triplets chosen from the array
// that can make triangles if we take them as side lengths of a triangle.
//        Example 1:
//        Input: [2,2,3,4]
//        Output: 3
//        Explanation:
//        Valid combinations are:
//        2,3,4 (using the first 2)
//        2,3,4 (using the second 2)
//        2,2,3
//        Note:
//        The length of the given array won't exceed 1000.
//        The integers in the given array are in the range of [0, 1000].

/**
 * 1. key point -> how to construct a triangle
 * x + y > z
 * x + z > y
 * y + z > x
 *
 * 2. using order trick
 * For x <= y <= z
 * ---> we only need to guarantee x + y > z
 * ---> find if there is any index tuple,
 * such that i < j < k,
 * and array[i] + array[j] > array[k]
 *
 * 3.
 * for all k:
 * find # of pairs of (i, j),
 * i < j < k,
 * array[i] + array[j] > array[k]
 * ---> 2 sum larger than target
 *
 * Time: O(n ^ 2)
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int j = i + 1;
            int k = i + 2;
            while (j < nums.length - 1) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                // nums[i] + nums[j] <= nums[k]
                count += k - j - 1;
                j++;
            }
        }
        return count;
    }
}
