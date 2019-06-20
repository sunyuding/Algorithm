package hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time: O(strs.length * str.length())
 * Space: O(strs.length * str.length())
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> patterns = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> pattern = new HashMap<>();
            for (char ch : str.toCharArray()) {
                pattern.put(ch, pattern.getOrDefault(ch, 0) + 1);
            }
            if (!patterns.containsKey(pattern)) {
                patterns.put(pattern, new ArrayList<>());
            }
            patterns.get(pattern).add(str);
        }
        for (List<String> list : patterns.values()) {
            result.add(list);
        }
        return result;
    }
}
