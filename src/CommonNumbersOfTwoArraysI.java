//import java.util.*;
//
////Description
////        Find all numbers that appear in both of two unsorted arrays.
////
////        Assumptions
////
////        Both of the two arrays are not null.
////        In any of the two arrays, there could be duplicate numbers.
////        Examples
////
////        A = {1, 2, 3, 2}, B = {3, 4, 2, 2, 2},
////        return [2, 2, 3] (there are both two 2s in A and B)
////
////
////        Easy
////        Hashtable
//
//public class CommonNumbersOfTwoArraysI {
//    public List<Integer> common(List<Integer> A, List<Integer> B) {
//        List<Integer> result = new ArrayList<Integer>();
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < A.size(); i++) {
//            int a = A.get(i);
//            if (map.containsKey(a)) {
//                map.put(a, map.get(a) + 1);
//            } else {
//                map.put(a, 1);
//            }
//        }
//        for (int j = 0; j < B.size(); j++) {
//            int b = B.get(j);
//            if (map.containsKey(b)) {
//                result.add(b);
//                map.put(b, map.get(b) - 1);
//            }
//        }
//        Collections.sort(result);
//        return result;
//    }
//
//    private List<Integer> common1(List<Integer> A, List<Integer> B) {
//        List<Integer> result = new ArrayList<Integer>();
//        Collections.sort(A);
//        Collections.sort(B);
//        int i = 0;
//        int j = 0;
//        while (i < A.size() || j < B.size()) {
//            if (A.get(i) == B.get(j)) {
//                result.add(A.get(i));
//                i++;
//                j++;
//            } else if (A.get(i) < B.get(j)) {
//                i++;
//            } else if{
//                j++;
//            }
//        }
//        return result;
//    }
//
//}
