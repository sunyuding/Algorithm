package array;
//Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it is able to trap after raining.
//
//
//        The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
// In this case, 6 units of rain water (blue section) are being trapped.
// Thanks Marcos for contributing this image!
//
//        Example:
//
//        Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//        ---> :  0,1,1,2,2,2,2,3,3,3,3,3
//        <--- :  3,3,3,3,3,3,3,3,2,2,2,1
//        min  :  0,1,1,2,2,2,2,3,2,2,2,1
//        diff :  0,0,1,0,1,2,1,0,0,1,0,0
//        Output: 6
// Time: O(n)
// Space: O(n)

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int[] leftToRight = new int[height.length];
        int[] rightToLeft = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                leftToRight[i] = height[i];
            } else {
                leftToRight[i] = Math.max(leftToRight[i - 1], height[i]);
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                rightToLeft[i] = height[i];
            } else {
                rightToLeft[i] = Math.max(rightToLeft[i + 1], height[i]);
            }
        }
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            result += Math.min(leftToRight[i], rightToLeft[i]) - height[i];
        }
        return result;
    }
}
