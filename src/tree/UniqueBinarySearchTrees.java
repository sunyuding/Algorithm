package tree;
//Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
//
//        Example:
//
//        Input: 3
//        Output: 5
//        Explanation:
//        Given n = 3, there are a total of 5 unique BST's:
//
//        1         3     3      2      1
//        \       /     /      / \      \
//        3     2     1      1   3      2
//        /     /       \                 \
//        2     1         2                 3
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        return numTrees(1, n);
    }
// numTrees(1, 3)
    // i = 1,
    // numTrees(2, 3)
    // i = 2
    private int numTrees(int s, int l) {
        if (s >= l) return 1;
        int count = 0;
        for (int i = s; i <= l; i++) {
            count += (numTrees(s, i - 1) * numTrees(i + 1, l));
        }
        return count;
    }
}
