/**
 * This is a follow up of Shortest Word Distance.
 * The only difference is now word1 could be the same as word2.
 *
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * word1 and word2 may be the same and they represent two individual words in the list.
 *
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *                                      p1
 *                p2
 *
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 *
 * Note:
 * You may assume word1 and word2 are both in the list.
 *
 * Medium
 * Array
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            return shortestSameWordDistance(words, word1, word2);
        } else {
            return shortestDiffWordDistance(words, word1, word2);
        }
    }

    private int shortestDiffWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
                if (p2 != -1) {
                    result = Math.min(result, Math.abs(p1 - p2));
                }
            }
            if (words[i].equals(word2)) {
                p2 = i;
                if (p1 != -1) {
                    result = Math.min(result, Math.abs(p1 - p2));
                }
            }
        }
        return result;
    }

    private int shortestSameWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int result = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                count++;
                if (count % 2 == 1) {
                    p1 = i;
                } else {
                    p2 = i;
                }
                if (p1 != -1 && p2 != -1) {
                    result = Math.min(result, Math.abs(p1 - p2));
                }
            }
        }
        return result;
    }
}
