import java.util.Map;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 In this case, 6 units of rain water (blue section) are being trapped.
 Thanks Marcos for contributing this image!

 Example:

 Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int res = 0;
        if (height == null || height.length == 0) {
            return res;
        }
        // from current element to left and to right
        // find the highest index left side and right side

        //  0 1 2 3 4 5 6 7 8 9 0 1
        // [0,1,0,2,1,0,1,3,2,1,2,1]
        // to left
        // [0,0,1,1,2,2,2,2,3,3,3,3]

        int[] toLeft = new int[height.length];
        toLeft[0] = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > toLeft[i - 1]) {
                toLeft[i] = height[i - 1];
            } else {
                toLeft[i] = toLeft[i - 1];
            }
        }
        //  0 1 2 3 4 5 6 7 8 9 0 1
        // [0,1,0,2,1,0,1,3,2,1,2,1]
        // to right
        // [3,3,3,3,3,3,3,2,2,2,1,0]
        int[] toRight = new int[height.length];
        toRight[toLeft.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i + 1] > toRight[i + 1]) {
                toRight[i] = height[i + 1];
            } else {
                toRight[i] = toRight[i + 1];
            }
        }

        // find all local minimun
        for (int i = 1; i < height.length - 1; i++) {
            int h = Math.min(toLeft[i], toRight[i]);
            res += Math.max(h - height[i], 0);
        }
        return res;
    }

    public static void main(String[] args) {
        TrappingRainWater ins = new TrappingRainWater();
        int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        ins.trap(height);
    }
}
