package tree;

public class ShortestDistanceOfXAndY {
    // Note:
    // 0 for X and 1 for Y
    int shortest = Integer.MAX_VALUE;

    public int shortestDistance(TreeNode root) {
        bottomUp(root);
        return shortest;
    }

    private int[] bottomUp(TreeNode root) {
        if (root == null) return new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};

        if (root.left == null && root.right == null) {
            if (root.val == 0) {
                // root is X
                return new int[]{1, Integer.MAX_VALUE};
            }
            if (root.val == 1) {
                // root is Y
                return new int[]{Integer.MAX_VALUE, 1};
            }
        }

        int[] left = bottomUp(root.left);
        int[] right = bottomUp(root.right);

        if (root.val == 0) {
            // root is X
            int y = Math.min(left[1], right[1]);
            if (y != Integer.MAX_VALUE) {
                shortest = Math.min(shortest, y + 1);
            }
        } else if (root.val == 1) {
            // root is Y
            int x = Math.min(left[0], right[0]);
            if (x != Integer.MAX_VALUE) {
                shortest = Math.min(shortest, x + 1);
            }
        } else {
            if (left[0] != Integer.MAX_VALUE && right[1] != Integer.MAX_VALUE) {
                shortest = Math.min(shortest, left[0] + right[1] + 1);
            }
            if (left[1] != Integer.MAX_VALUE && right[0] != Integer.MAX_VALUE) {
                shortest = Math.min(shortest, left[1] + right[1] + 1);
            }
        }

        int minX = Math.min(left[0], right[0]);
        int minY = Math.min(left[1], right[1]);

        return new int[] {minX == Integer.MAX_VALUE? Integer.MAX_VALUE : minX + 1,
                minY == Integer.MAX_VALUE? Integer.MAX_VALUE : minY + 1};
    }
}
