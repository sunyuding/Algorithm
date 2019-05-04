//Description
//        Remove adjacent,
// repeated characters in a given string,
// leaving no character for each group of such characters.
// The characters in the string are sorted in ascending order.
//
//        Assumptions
//
//        Try to do it in place.
//        Examples
//
//        “aaaabbbc” is transferred to “c”
//        Corner Cases
//
//        If the given string is null,
// we do not need to do anything.
//        Medium
//        array
//        String
public class RemoveAdjacentRepeatedCharactersIII {
    public String deDup(String input) {
        if (input == null || input.length() < 2) {
            return input;
        }
        char[] charArray = input.toCharArray();
        int j = 0;// substring(0,j) is result
        //aaaabbbc
        //   i
        //j
        if (charArray[0] != charArray[1]) {
            charArray[j] = charArray[0];
            j++;
        }
        for (int i = 1; i < charArray.length - 1; i++) {
            if (charArray[i] != charArray[i - 1] && charArray[i] != charArray[i + 1]) {
                //unique
                charArray[j] = charArray[i];
                j++;
            }
        }
        if (charArray[charArray.length - 1] != charArray[charArray.length - 2]) {
            charArray[j] = charArray[charArray.length - 1];
            j++;
        }
        return new String(charArray).substring(0, j);
    }
}
