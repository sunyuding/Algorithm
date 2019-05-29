package breadth_first_search;

import java.util.*;

//Given two words (beginWord and endWordWord),
// and a dictionary's word list,
// find all shortest transformation sequence(s) from beginWord to endWordWord,
// such that:
//
//        Only one letter can be changed at a time
//        Each transformed word must exist in the word list.
// Note that beginWord is not a transformed word.
//        Note:
//
//        Return an empty list if there is no such transformation sequence.
//        All words have the same length.
//        All words contain only lowercase alphabetic characters.
//        You may assume no duplicates in the word list.
//        You may assume beginWord and endWordWord are non-empty and are not the same.
//        Example 1:
//
//        Input:
//        beginWord = "hit",
//        endWordWord = "cog",
//        wordList = ["hot","dot","dog","lot","log","cog"]
//
//        Output:
//        [
//        ["hit","hot","dot","dog","cog"],
//        ["hit","hot","lot","log","cog"]
//        ]
//        Example 2:
//
//        Input:
//        beginWord = "hit"
//        endWordWord = "cog"
//        wordList = ["hot","dot","dog","lot","log"]
//
//        Output: []
//
//        Explanation: The endWordWord "cog" is not in wordList,
// therefore no possible transformation.

//public class WordLadderII {
//    public List<List<String>> findLadders(String beginWord, String endWordWord, List<String> wordList) {
//        int length = ladderLength(beginWord, endWordWord, wordList);
//        List<List<String>> res = new ArrayList<>();
//        List<String> path = new ArrayList<String>();
//        Set<String> visited = new HashSet<>();
//        path.add(beginWord);
//        visited.add(beginWord);
//        dfs(beginWord, endWordWord, wordList, path, res, length - 1, visited);
//        return res;
//    }
//
//    private void dfs(String beginWord, String endWordWord, List<String> wordList, List<String> path, List<List<String>> res, int length, Set<String> visited) {
//        if (length < 0) {
//            return;
//        }
//        if (beginWord.equals(endWordWord)) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for (String word : wordList) {
//            if (!visited.contains(word) && isNext(beginWord, word)) {
//                path.add(word);
//                visited.add(word);
//                dfs(word, endWordWord, wordList, path, res, length - 1, visited);
//                path.remove(path.size() - 1);
//                visited.remove(word);
//            }
//        }
//    }
//
//    private int ladderLength(String beginWord, String endWordWord, List<String> wordList) {
//        int length = 1;
//        Queue<String> q = new LinkedList<>();
//
//        Set<String> visited = new HashSet<>();
//
//        q.offer(beginWord);
//        visited.add(beginWord);
//
//        while(!q.isEmpty()) {
//            int size = q.size();
//            for (int i = 0; i < size; i++) {
//                String cur = q.poll();
//                for (String word : wordList) {
//                    if (!visited.contains(word) && isNext(cur, word)) {
//                        if (word.equals(endWordWord)) {
//                            return length + 1;
//                        }
//                        q.offer(word);
//                        visited.add(word);
//                    }
//                }
//            }
//            length++;
//        }
//        return 0;
//    }
//
//    private boolean isNext(String cur, String next) {
//        int diff = 0;
//        for (int i = 0; i < cur.length(); i++) {
//            if (cur.charAt(i) != next.charAt(i) ) {
//                diff++;
//            }
//        }
//        return diff == 1;
//    }
//
//    public static void main(String[] args) {
//        WordLadderII ins = new WordLadderII();
//        String[] array = new String[] {"hot","dot","dog","lot","log","cog"};
//        ins.findLadders("hit", "cog", Arrays.asList(array));
//    }
//}

/**
 * Runtime: 103 ms
 * Memory Usage: 50.2 MB
 * Time:
 * Space:
 */
public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        HashSet<String> dict = new HashSet<>(wordList);

        Map<String, ArrayList<String>> nodeNeighbors = new HashMap<>();// Neighbors for every node
        Map<String, Integer> distance = new HashMap<>();// Distance of every node from the beginWord node

        dict.add(beginWord);
        bfs(beginWord, endWord, dict, nodeNeighbors, distance);

        ArrayList<String> solution = new ArrayList<>();
        dfs(beginWord, endWord, nodeNeighbors, distance, solution, res);
        return res;
    }

    // BFS: Trace every node's distance from the beginWord node (level by level).
    private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, ArrayList<String>> nodeNeighbors, Map<String, Integer> distance) {
        for (String str : dict)
            nodeNeighbors.put(str, new ArrayList<>());

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean foundEnd = false;

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                List<String> neighbors = getNeighbors(cur, dict);

                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {// Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (endWord.equals(neighbor)) {// Found the shortest path
                            foundEnd = true;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            if (foundEnd) {
                break;
            }
        }
    }

    // Find all next level nodes.
    private List<String> getNeighbors(String node, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String endWord, Map<String, ArrayList<String>> nodeNeighbors, Map<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (endWord.equals(cur)) {
            res.add(new ArrayList<>(solution));
        } else {
            for (String next : nodeNeighbors.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, endWord, nodeNeighbors, distance, solution, res);
                }
            }
        }
        solution.remove(solution.size() - 1);
    }
}