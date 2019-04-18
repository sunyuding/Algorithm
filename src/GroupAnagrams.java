import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<int[], List<String>> map = new HashMap<>();
        for (String s : strs) {
            // pattern for s
            int[] array = new int[26];
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                array[index]++;
            }
            List<String> list = map.get(array);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(s);
            map.put(array, list);
        }
        for (Map.Entry entry : map.entrySet()) {
            result.add((List<String>)entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        GroupAnagrams ins = new GroupAnagrams();
        ins.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
