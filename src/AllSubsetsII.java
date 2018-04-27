import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Description
//        Given a set of characters represented by a String,
//        return a list containing all subsets of the characters.
//
//        Assumptions
//
//        There could be duplicate characters in the original set.
//        ​Examples
//
//        Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
//        Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
//        Set = "", all the subsets are [""]
//        Set = null, all the subsets are []
//        Hard
//        Depth First Search

public class AllSubsetsII {
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] arrayOfSet = set.toCharArray();
        Arrays.sort(arrayOfSet);
        StringBuilder buffer = new StringBuilder();
        dfs(arrayOfSet, buffer, 0, result);
        return result;
    }

    private void dfs(char[] set, StringBuilder buffer, int index, List<String> result) {
        if (index == set.length) {
            result.add(buffer.toString());
            return;
        }
        int i = index + 1;
        // without this char set[index]
        // find the next char
        while(i < set.length && set[i] == set[i - 1]) {
            i++;
        }
        // set[i] is a new char right now
        dfs(set, buffer, i, result);
        // add set[index]
        dfs(set, buffer.append(set[index]), index + 1, result);
        buffer.deleteCharAt(buffer.length() - 1);
    }
}
