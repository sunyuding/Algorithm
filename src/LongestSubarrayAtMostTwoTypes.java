import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayAtMostTwoTypes {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) return 0;
        int max = 0;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < tree.length; j++) {
            if (map.containsKey(tree[j])) {
                map.put(tree[j], map.get(tree[j]) + 1);
            } else {
                map.put(tree[j], 1);
            }
            while(map.size() > 2) {
                map.put(tree[i], map.get(tree[i]) - 1);
                if (map.get(tree[i]) == 0) {
                    map.remove(tree[i]);
                }
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubarrayAtMostTwoTypes ins = new LongestSubarrayAtMostTwoTypes();
        ins.totalFruit(new int[] {4,1,1,1,3,1,7,5});
    }
}
