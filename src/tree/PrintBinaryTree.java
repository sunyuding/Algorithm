package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrintBinaryTree {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (root == null) return res;
        int height = getHeight(root);
        int rows = height, columns = (int) Math.pow(2, height) - 1;
        for(int i = 0; i < rows; i++){
            String[] temp = new String[columns];
            Arrays.fill(temp, "");
            res.add(Arrays.asList(temp));
        }
        traverse(root, res, 0, rows, 0, columns - 1);
        return res;
    }
    // traverse the tree level by level and fill in the result
    private void traverse(TreeNode root, List<List<String>> res, int row, int rowNumber, int left, int right) {
        if (row == rowNumber || root == null) return;
        int mid = left + (right - left)/2;
        res.get(row).set(mid, Integer.toString(root.val));
        traverse(root.left, res, row + 1, rowNumber, left, mid - 1);
        traverse(root.right, res, row + 1, rowNumber, mid + 1, right);
    }

    //O(n)
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
