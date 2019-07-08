package tree;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        if(root == null) return result;
        List<TreeNode> leftList = new ArrayList<>();
        if(root.left != null) {
            leftList = delNodes(root.left, to_delete);
            for(int i : to_delete) {
                if(root.left.val == i) {
                    root.left = null;
                }
            }
        }
        List<TreeNode> rightList = new ArrayList<>();
        if (root.right != null) {
            rightList = delNodes(root.right, to_delete);
            if(root.right != null) {
                for (int i : to_delete) {
                    if (root.right.val == i) {
                        root.right = null;
                    }
                }
            }
        }
        boolean rootToDelete = false;
        for(int i : to_delete) {
            if(root.val == i) {
                rootToDelete = true;
            }
        }
        if(rootToDelete) {
            root.left = null;
            root.right = null;
            result.addAll(leftList);
            result.addAll(rightList);
        } else {
            leftList.remove(root.left);
            rightList.remove(root.right);
            result.addAll(leftList);
            result.addAll(rightList);
            result.add(root);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n2.right = n3;
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n2.left = n4;
        n2.right = n5;
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n3.left = n6;
        n3.right = n7;
        DeleteNodesAndReturnForest ins = new DeleteNodesAndReturnForest();
        ins.delNodes(n1, new int[] {3, 5});
    }
}
