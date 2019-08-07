package two_pointers;
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
// Space: O(1)
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int result = 0;
        int left = 0, right = height.length - 1;
        int boundary = 0;
        while(left <= right) {
            if (height[left] < height[right]) {
                boundary = Math.max(boundary, height[left]);
                result += boundary - height[left++];
            } else {
                boundary = Math.max(boundary, height[right]);
                result += boundary - height[right--];
            }
        }
        return result;
    }
}
