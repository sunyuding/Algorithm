//Description
//        Remove adjacent,
// repeated characters in a given string,
// leaving only two characters for each group of such characters.
// The characters in the string are sorted in ascending order.
//
//        Assumptions
//
//        Try to do it in place.
//        Examples
//
//        “aaaabbbc” is transferred to “aabbc”
//        Corner Cases
//
//        If the given string is null, we do not need to do anything.
//        Medium
//        Array
//        String

import java.util.Arrays;

public class RemoveAdjacentRepeatedCharactersII {
    public String deDup(String input) {
        if (input.length() < 2) {
            return input;
        }
        char[] charArray = input.toCharArray();

        int i = 0;
        int j = 0;// result is substring(0, j)
//          abc
        //     i
        //     j
        while (i < charArray.length - 1) {
            if (charArray[i] == charArray[i + 1]) {
                charArray[j] = charArray[i];
                j++;
                charArray[j] = charArray[i];
                j++;
                while(i + 1 < charArray.length && charArray[i] == charArray[i+1]) {
                    i++;
                }
                if (i == charArray.length - 1) {
                    // i reach the end and till the same char
                    break;

                }
                if (charArray[i] != charArray[i+1]) {
                    i++;
                }
            } else {
                //charArray[i] != charArray[i + 1]
                charArray[j] = charArray[i];
                i++;
                j++;
            }
        }

        if (charArray[i] != charArray[j - 1]) {
            charArray[j] = charArray[i];
            j++;
        }
        //reach the end
        String result = new String(charArray);
        return result.substring(0, j);
    }

    public static void main(String[] args) {
        RemoveAdjacentRepeatedCharactersII rarc = new RemoveAdjacentRepeatedCharactersII();
        rarc.deDup("abc");
    }
}
