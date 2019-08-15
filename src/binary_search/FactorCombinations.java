package binary_search;

import java.util.ArrayList;
import java.util.List;

//Numbers can be regarded as product of its factors. For example,
//
//        8 = 2 x 2 x 2;
//        = 2 x 4.
//        Write a function that takes an integer n and return all possible combinations of its factors.
//
//        Note:
//
//        You may assume that n is always positive.
//        Factors should be greater than 1 and less than n.
//        Example 1:
//
//        Input: 1
//        Output: []
//        Example 2:
//
//        Input: 37
//        Output:[]
//        Example 3:
//
//        Input: 12
//        Output:
//        [
//        [2, 6],
//        [2, 2, 3],
//        [3, 4]
//        ]
//        Example 4:
//
//        Input: 32
//        Output:
//        [
//        [2, 16],
//        [2, 2, 8],
//        [2, 2, 2, 4],
//        [2, 2, 2, 2, 2],
//        [2, 4, 4],
//        [4, 8]
//        ]
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTracking(n, n, 2, result, path);
        return result;
    }

    private void backTracking(int n, int rest, int factor, List<List<Integer>> result, List<Integer> path) {
        if (rest == 1) {
            if (path.size() != 0) {
                result.add(new ArrayList<>(path));  // initialize a new list
            }
            return;
        }
        for (int i = factor; i <= rest && i < n; i++) {
            if (rest % i == 0) {
                // i is a factor
                path.add(i);
                backTracking(n, rest / i, i, result, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
