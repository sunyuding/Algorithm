package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {
    Map<Integer, List<TreeNode>> fullBTMap = new HashMap<>();

    /**
     * Time: O(2 ^ N)
     * Space: O(2 ^ N)
     *                                                   allPossibleFBT(N)
     *                       |                            |                                              |
     * allPossibleFBT(0),allPossibleFBT(N - 1)   allPossibleFBT(1),allPossibleFBT(N - 2) allPossibleFBT(2),allPossibleFBT(N - 3)
     *                      /
     *        allPossibleFBT(0),allPossibleFBT(N - 2)
     * @param N
     * @return
     */
    public List<TreeNode> allPossibleFBT(int N) {
        if (fullBTMap.containsKey(N)) {
            return fullBTMap.get(N);
        }
        List<TreeNode> result = new ArrayList<>();
        if (N == 0) {
            fullBTMap.put(0, result);
            return result;
        }
        //case1 : leaf node
        if (N == 1) {
            result.add(new TreeNode(0));
            fullBTMap.put(1, result);
            return result;
        }
        for (int i = 0; i < N - 1; i++) {
            List<TreeNode> leftList = allPossibleFBT(i);
            List<TreeNode> rightList = allPossibleFBT(N - 1 - i);
            //case 2: not leaf node
            if (!leftList.isEmpty() && !rightList.isEmpty()) {
                for (TreeNode leftNode : leftList) {
                    for (TreeNode rightNode : rightList) {
                        TreeNode root = new TreeNode(0);
                        root.left = leftNode;
                        root.right = rightNode;
                        result.add(root);
                    }
                }
            }
        }
        fullBTMap.put(N, result);
        return result;
    }
}
