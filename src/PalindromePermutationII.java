import java.util.*;

/**
 * Given a string s,
 * return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 *
 * For example:
 *
 * Given s = "aabb", return ["abba", "baab"].
 *
 * Given s = "abc", return [].
 *
 * Medium
 * Backtracking
 */
public class PalindromePermutationII {
    public String[] generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        if(!canPermutePalindrome(s)) {
            return result.toArray(new String[result.size()]);
        }
        char[] arrayS = s.toCharArray();
        Arrays.sort(arrayS);

        // String: left + mid + right

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        String mid = "";

        StringBuilder leftBuilder = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                mid = entry.getKey().toString();
            }
                for (int i = 0; i < entry.getValue() / 2; i++) {
                    leftBuilder.append(entry.getKey());
                }

        }

        return allPermutation(leftBuilder.toString(), mid);
    }

    private boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        if (set.size() > 1) {
            return false;
        } else {
            return true;
        }
    }

    private String[] allPermutation(String left, String mid) {
        List<String> list = new ArrayList<>();
        char[] array = left.toCharArray();

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (i == j || array[i] != array[j]) {
                    swap(array, i, j);
                    String newLeft = new String(array);
                    list.add(newLeft + mid + reverseString(newLeft));
                    swap(array, i, j);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }

    private void swap(char[] array, int left, int right) {
        while(left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    private String reverseString(String left) {
        char[] array = new char[left.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = left.charAt(array.length - 1 - i);
        }
        return new String(array);
    }

    public static void main(String[] args) {
        PalindromePermutationII pp = new PalindromePermutationII();
        pp.generatePalindromes("abcba");
    }
}
