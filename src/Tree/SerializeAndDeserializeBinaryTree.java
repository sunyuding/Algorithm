package Tree;

import java.util.*;

//Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
//
//        Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
//        Example:
//
//        You may serialize the following tree:
//
//            1
//           / \
//          2   3
//         /  \
//        4   5
//
//        as "[1,2,3,null,null,4,5]"
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // pre order
        if (root == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",").append(serialize(root.left));
        sb.append(",").append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeString = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodeString));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        TreeNode root = null;
        String cur = queue.poll();
        if (!cur.equals("null")) {
            root = new TreeNode(Integer.parseInt(cur));
            root.left = helper(queue);
            root.right = helper(queue);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        SerializeAndDeserializeBinaryTree ins = new SerializeAndDeserializeBinaryTree();
        String str = ins.serialize(node1);
        System.out.println(str);
        ins.deserialize(str);
    }
}
