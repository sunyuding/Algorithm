package array;

/**
 * Time: O(n)
 * Space: O(1)
 */
public class ShortestDistanceOfXAndY {
    // "X" - "Y"
    public int shortestDistance(String[] array) {
        if (array == null) return 0;
        int lastX = -1;
        int lastY = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("X")) {
                lastX = i;
                if (lastY != -1) {
                    result = Math.min(result, i - lastY + 1);
                }
            } else if (array[i].equals("Y")) {
                lastY = i;
                if (lastX != -1) {
                    result = Math.min(result, i - lastX + 1);
                }
            }
        }
        return result;
    }
}
