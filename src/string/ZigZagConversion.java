package string;

import java.util.ArrayList;
import java.util.List;

//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
// (you may want to display this pattern in a fixed font for better legibility)
//
//        P   A   H   N
//        A P L S I I G
//        Y   I   R
//        And then read line by line: "PAHNAPLSIIGYIR"
//
//        Write the code that will take a string and make this conversion given a number of rows:
//
//        string convert(string s, int numRows);
//        Example 1:
//                    01234567890123
//        Input: s = "PAYPALISHIRING", numRows = 3
//              (3-1)x2 (2-1)x2 (3-1)x2
//                 +4  +2     +4
//                 04821357913260
//        Output: "PAHNAPLSIIGYIR"
//        Example 2:
//
//                    01234567890123
//        Input: s = "PAYPALISHIRING", numRows = 4
//        P     I     N
//        A   L S   I G
//        Y A   H R
//        P     I
//             (4-1)x2
//                 +6 +4
//
//        Output: "PINALSIGYAHRPI"
//        Explanation:
//
//        P0      I6      N2
//        A1   L5 S7   I1 G3
//        Y2 A4   H8 R0
//        P3      I9

/**
 * Time: O(min of s.length(), numRows)
 * Space: O(s.length())
 */
//public class ZigZagConversion {
//    public String convert(String s, int numRows) {
//        if (numRows <= 1) return s;
//        List<List<Character>> temp = new ArrayList<>();
//        for (int i = 0; i < numRows; i++) {
//            temp.add(new ArrayList<>());
//        }
//        int row = 0;
//        boolean down = true;
//        for (int i = 0; i < s.length(); i++) {
//            char cur = s.charAt(i);
//            temp.get(row).add(cur);
//            if (down) {
//                if (row < numRows - 1) {
//                    row++;
//                } else {
//                    down = false;
//                    row--;
//                }
//            } else {
//                if (row > 0) {
//                    row--;
//                } else {
//                    down = true;
//                    row++;
//                }
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (List<Character> list : temp) {
//            for (Character ch : list) {
//                sb.append(ch);
//            }
//        }
//        return sb.toString();
//    }
//}

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            //for each row
            for (int j = 0; j + i < n; j += cycleLen) {
                // for each cycle
                sb.append(s.charAt(j + i));
                // for the top and bottom rows,
                // there is only 1 char
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    // for the middle rows,
                    // there are 2 char
                    sb.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return sb.toString();
    }
}
