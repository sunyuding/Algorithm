package hash_table;

import java.util.HashMap;
import java.util.Map;

//Given two strings s and t,
// determine if they are isomorphic.
//
//        Two strings are isomorphic if the characters in s can be replaced to get t.
//
//        All occurrences of a character must be replaced with another character while preserving the order of characters.
// No two characters may map to the same character but a character may map to itself.
//
//        Example 1:
//
//        Input: s = "egg", t = "add"
//        Output: true
//        Example 2:
//
//        Input: s = "foo", t = "bar"
//        Output: false
//        Example 3:
//
//        Input: s = "paper", t = "title"
//        Output: true
//        Note:
//        You may assume both s and t have the same length.

/**
 * Time: O(len)
 * Space: O(1) 26
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> stMap = new HashMap<>();
        Map<Character, Character> tsMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (stMap.containsKey(s.charAt(i))) {
                if (stMap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
            if (tsMap.containsKey(t.charAt(i))) {
                if (tsMap.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            }
            stMap.put(s.charAt(i), t.charAt(i));
            tsMap.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
}
