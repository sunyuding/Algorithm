package tree;

import java.util.ArrayDeque;
import java.util.Deque;

//536. Construct Binary tree from String
//You need to construct a binary tree from a string consisting of parenthesis and integers.
//
//        The whole input represents a binary tree.
// It contains an integer followed by zero,
// one or two pairs of parenthesis.
// The integer represents the root's value
// and a pair of parenthesis contains a child binary tree with the same structure.
//
//        You always start to construct the left child node of the parent first if it exists.
//Example:
//        Input: "4(2(3)(1))(6(5))"
//        Output: return the tree root node representing the following tree:
//
//            4
//          /   \
//         2     6
//        / \   /
//       3  1  5
//Note:
//        There will only be '(', ')', '-' and '0' ~ '9' in the input string.
//        An empty tree is represented by "" instead of "()".
public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;
        int slow = 0;
        int fast = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();

        while(fast < s.length()) {
            // 0123456789012345
            //"4(2(3)(1))(6(5))"
            //                s
            //                 f
            while(fast < s.length() && s.charAt(fast) != '(' && s.charAt(fast) != ')') {
                fast++;
            }
            // fast over || fast == '(' || fast == ')'
            if (fast > slow) {
                int value = Integer.parseInt(s.substring(slow, fast));//4
                TreeNode node = new TreeNode(value);//4
                if (!stack.isEmpty()) {
                    if (stack.peek().left == null) {
                        stack.peek().left = node;
                    } else {
                        stack.peek().right = node;
                    }
                }
                stack.push(node);
            }

            if (fast < s.length() && s.charAt(fast) == ')') {
                stack.pop();
            }
            fast++;
            slow = fast;
        }
        return stack.pop();
    }
}
