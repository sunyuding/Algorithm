import java.util.ArrayList;
import java.util.List;

/**
 * Given a telephone keypad,
 * and an int number,
 * print all words which are possible by pressing these numbers,
 * the output strings should be sorted.
 *
 * {0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"}
 *
 * Assumptions:
 *
 * The given number >= 0
 * Examples:
 *
 * if input number is 231, possible words which can be formed are:
 *
 * [ad, ae, af, bd, be, bf, cd, de, df]
 *
 * Medium
 * Depth First Search
 */
public class CombinationsForTelephonePadI {
    public String[] combinations(int number) {
        String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv","wxyz"};
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(String.valueOf(number), 0, dict, sb, result);
        return listToArray(result);
    }

    private void dfs(String number, int index, String[] dict, StringBuilder sb, List<String> result) {
        if (index == number.length()) {
            result.add(sb.toString());
            return;
        }
        int digit = Character.getNumericValue(number.charAt(index));
        String key = dict[digit];
        if (key.length() > 0) {
            for (int i = 0; i < key.length(); i++) {
                sb.append(key.charAt(i));
                dfs(number,index + 1, dict, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        } else {
            dfs(number, index + 1, dict, sb, result);
        }
    }

    private String[] listToArray(List<String> list) {
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        CombinationsForTelephonePadI cftp = new CombinationsForTelephonePadI();
        cftp.combinations(2014);
    }
}
