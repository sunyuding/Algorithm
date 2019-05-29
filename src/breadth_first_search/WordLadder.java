package breadth_first_search;

import java.util.*;

public class WordLadder {
    /**
     * Runtime: 737 ms
     * Memory Usage: 37.8 MB
     * Time: O(n * n * length)
     * Space: O(n)
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = 1;
        Queue<String> q = new LinkedList<>();

        Set<String> visited = new HashSet<>();

        q.offer(beginWord);
        visited.add(beginWord);

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                for (String word : wordList) {
                    if (!visited.contains(word) && isNext(cur, word)) {
                        if (word.equals(endWord)) {
                            return length + 1;
                        }
                        q.offer(word);
                        visited.add(word);
                    }
                }
            }
            length++;
        }
        return 0;
    }

    private boolean isNext(String cur, String next) {
        int diff = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != next.charAt(i) ) {
                diff++;
            }
        }
        return diff == 1;
    }
}
