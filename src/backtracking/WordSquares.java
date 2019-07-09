package backtracking;

import java.util.*;

public class WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Map<String, Set<String>> prefixMap = new HashMap<>();
        backtracking(words, 0, words[0].length(), path, result, prefixMap);
        return result;
    }

    private void backtracking(String[] words, int index, int length, List<String> path, List<List<String>> result, Map<String, Set<String>> prefixMap) {
        if (index == length) {
            result.add(new ArrayList<>(path));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < index; i++) {
            prefix.append(path.get(i).charAt(index));
        }
        if (prefixMap.containsKey(prefix.toString())) {
            for (String word : prefixMap.get(prefix.toString())) {
                path.add(word);
                backtracking(words, index + 1, length, path, result, prefixMap);
                path.remove(path.size() - 1);
            }
        } else {
            for (String word : words) {
                if (word.substring(0, index).equals(prefix.toString())) {
                    if (!prefixMap.containsKey(prefix.toString())) {
                        prefixMap.put(prefix.toString(), new HashSet<>());
                    }
                    prefixMap.get(prefix.toString()).add(word);
                    path.add(word);
                    backtracking(words, index + 1, length, path, result, prefixMap);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
