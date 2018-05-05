/**
 * Reverse the words in a sentence and truncate all heading/trailing/duplicate space characters.
 *
 * Examples
 *
 * “ I  love  Google  ” → “Google love I”
 *
 * Corner Cases
 *
 * If the given string is null, we do not need to do anything.
 * Medium
 * String
 */
public class ReverseWordsInASentenceII {
    public String reverseWords(String input) {
        input = input.trim();
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] inputArray = input.toCharArray();
        reverse(inputArray, 0, inputArray.length - 1);
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] != ' ' && (i == 0 || inputArray[i - 1] ==' ')) {
                // i is the start of a word
                start = i;
            }

            if (inputArray[i] == ' ' && (i == 0 || inputArray[i - 1] != ' ')) {
                // i is the end of a word (not including i)

                // everytime update a new end, reverse the word
                reverse(inputArray, start, i - 1);
                sb.append(input.substring(start, i));
            }
        }
        sb.append(input.substring(start, inputArray.length));
        return sb.toString();
    }

    private void reverse(char[] input, int start, int end) {
        while (start < end) {
            char tmp = input[start];
            input[start] = input[end];
            input[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInASentenceII rwias = new ReverseWordsInASentenceII();
        rwias.reverseWords(" a");
    }
}
