package breadth_first_search;

import java.util.*;

// Remove the minimum number of invalid parentheses in order to make the input string valid.
// Return all possible results.
//
//        Note: The input string may contain letters other than the parentheses ( and ).
//
//        Example 1:
//
//        Input: "()())()"
//        Output: ["()()()", "(())()"]
//
//        Example 2:
//
//        Input: "(a)())()"
//        Output: ["(a)()()", "(a())()"]
//
//        Example 3:
//
//        Input: ")("
//        Output: [""]

/**
 * Runtime: 67 ms
 * Memory Usage: 41.3 MB
 * Time: O(V + E)
 * Space: O(V)
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        visited.add(s);
        boolean found = false;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (isValid(cur)) {
                    result.add(cur);
                    found = true;
                }
                for (int j = 0; j < cur.length(); j++) {
                    if (cur.charAt(j) == '(' || cur.charAt(j) == ')') {
                        String newStr = cur.substring(0, j) + cur.substring(j + 1);//remove the current char
                        if (!visited.contains(newStr)) {
                            q.offer(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }
            if (found) {
                break;
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int leftPare = 0;
        int rightPare = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftPare++;
            }
            if (s.charAt(i) == ')') {
                rightPare++;
            }
            if (rightPare > leftPare) {
                return false;
            }
        }
        return leftPare == rightPare;
    }
}
