public class Dictionary {
    public boolean dictionary(String input, String[] dict) {
        if (input == null || dict == null || dict.length == 0) {
            return false;
        }
// dp[i] represents from 0-th to (i - 1)-th substring …
        boolean[] dp = new boolean[input.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= input.length(); i++) {
            String dpString = input.substring(0, i);
            if (contains(dict, dpString)) {
                dp[i] = true;
            } else {
                for (int j = 1; j < i; j++) {
                    dpString = input.substring(j, i);
                    if (dp[j] && contains(dict, dpString)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[input.length()];
    }

    private boolean contains(String[] arr, String target) {
        for (String s:arr) {
            if (s.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        String input = "defabcdef";
        String[] dict = new String[]{"abc", "ab", "cd", "de", "def"};

        boolean result = dictionary.dictionary(input, dict);
        System.out.println(result);
    }

}
