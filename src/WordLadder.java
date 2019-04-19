import java.util.*;

public class WordLadder {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int length = ladderLength(beginWord, endWord, wordList);
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, wordList, result, path, length - 1);
        return result;
    }

    private void dfs(String beginWord, String endWord, List<String> wordList, List<List<String>> result, List<String> path, int length) {
        if (length == 0) {
            if (beginWord.equals(endWord)) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (String word : wordList) {
            if (!path.contains(word) && isConnected(beginWord, word)) {
                path.add(word);
                dfs(word, endWord, wordList, result, path, length - 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);//"hit"
        queue.offer(beginWord);//"hit"

        while(!queue.isEmpty()) {
            int size = queue.size();//1
            result++;//2
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();//"hit"
                for (String word : wordList) {
                    if (!visited.contains(word) && isConnected(cur, word)) {
                        if (word.equals(endWord)) {
                            return result ;
                        }
                        visited.add(word);
                        queue.offer(word);
                    }
                }
            }
        }
        return 0;
    }

    private boolean isConnected(String cur, String word) {
        int count = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != word.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) {
        WordLadder ins = new WordLadder();
        ins.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
    }
}
