/**
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines,
 * which together with x-axis forms a container,
 * such that the container contains the most water.
 * Note: You may not slant the container.
 *
 * Easy
 * array
 * Two Pointers
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // right side is guarantee to be height.length - 1
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                result = Math.max(result, area);
            }
        }
        return result;
    }
    // O(n)
}
