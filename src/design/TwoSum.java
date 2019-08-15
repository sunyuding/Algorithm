package design;
//Design and implement a TwoSum class.
// It should support the following operations: add and find.
//
//        add - Add the number to an internal data structure.
//        find - Find if there exists any pair of numbers which sum is equal to the value.
//
//        Example 1:
//
//        add(1); add(3); add(5);
//        find(4) -> true
//        find(7) -> false
//        Example 2:
//
//        add(3); add(1); add(2);
//        find(3) -> true
//        find(6) -> false

import java.util.*;

//public class TwoSum {
//    Set<Integer> numSet;
//    Set<Integer> sumSet;
//
//    /** Initialize your data structure here. */
//    public TwoSum() {
//        numSet = new HashSet<>();
//        sumSet = new HashSet<>();
//    }
//
//    /** Add the number to an internal data structure..
//     */
//    public void add(int number) {
//        if (numSet.contains(number)) {
//            sumSet.add(number * 2);
//        } else {
//            Iterator<Integer> iter = numSet.iterator();
//            while(iter.hasNext()) {
//                sumSet.add(iter.next() + number);
//            }
//            numSet.add(number);
//        }
//    }
//
//    /** Find if there exists any pair of numbers which sum is equal to the value. */
//    public boolean find(int value) {
//        return sumSet.contains(value);
//    }
//}

public class TwoSum {
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure..
     * O(1)
     * */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value.
     * O(n)
     * */
    public boolean find(int value) {
        for (Integer num : map.keySet()) {
            int target = value - num;
            if (map.containsKey(target)) {
                if (num != target || map.get(num) > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

