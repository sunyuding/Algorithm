package two_pointers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// In a row of trees,
// the i-th tree produces fruit with type tree[i].
//
//        You start at any tree of your choice,
// then repeatedly perform the following steps:
//
//        Add one piece of fruit from this tree to your baskets.
// If you cannot,
// stop.
//        Move to the next tree to the right of the current tree.
// If there is no tree to the right,
// stop.
//        Note that you do not have any choice after the initial choice of starting tree:
// you must perform step 1,
// then step 2,
// then back to step 1,
// then step 2,
// and so on until you stop.
//
//        You have two baskets,
// and each basket can carry any quantity of fruit,
// but you want each basket to only carry one type of fruit each.
//
//        What is the total amount of fruit you can collect with this procedure?
//
//        Example 1:
//
//        Input: [1,2,1]
//        Output: 3
//        Explanation: We can collect [1,2,1].
//
//        Example 2:
//
//        Input: [0,1,2,2]
//        Output: 3
//        Explanation: We can collect [1,2,2].
//        If we started at the first tree, we would only collect [0, 1].
//
//        Example 3:
//
//        Input: [1,2,3,2,2]
//        Output: 4
//        Explanation: We can collect [2,3,2,2].
//        If we started at the first tree, we would only collect [1, 2].
//
//        Example 4:
//
//        Input: [3,3,3,1,2,1,1,2,3,3,4]
//        Output: 5
//        Explanation: We can collect [1,2,1,1,2].
//        If we started at the first tree or the eighth tree, we would only collect 4 fruits.
//
//
//        Note:
//
//        1 <= tree.length <= 40000
//        0 <= tree[i] < tree.length

/**
 * Time: O(n)
 * Space: O(1)
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }
        int totalAmount = 0;
        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        int start = 0;
        //O(n)
        for (int i = 0; i < tree.length; i++) {
            int curFruit = tree[i];
            if (!lastIndexMap.containsKey(curFruit) && lastIndexMap.keySet().size() >= 2) {
                int smallestLastIndex = Integer.MAX_VALUE;
                int fruteToRemove = 0;
                // O(1)
                for (Map.Entry<Integer, Integer> entry : lastIndexMap.entrySet()) {
                    if (entry.getValue() < smallestLastIndex) {
                        fruteToRemove = entry.getKey();
                        smallestLastIndex = entry.getValue();
                    }
                }
                lastIndexMap.remove(fruteToRemove);
                start = smallestLastIndex + 1;
            }
            lastIndexMap.put(curFruit, i);
            totalAmount = Math.max(totalAmount, i - start + 1);
        }
        return totalAmount;
    }

    public static void main(String[] args) {
        FruitIntoBaskets ins = new FruitIntoBaskets();
        ins.totalFruit(new int[] {1,2,3,2,2});
    }
}
