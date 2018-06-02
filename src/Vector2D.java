//import java.util.Iterator;
//import java.util.List;
//
///**
// * Implement an iterator to flatten a 2d vector.
// *
// * Example:
// *
// * Input: 2d vector =
// * [
// *   [1,2],
// *   [3],
// *   [4,5,6]
// * ]
// * Output: [1,2,3,4,5,6]
// * Explanation:
// * By calling next repeatedly until hasNext returns false,
// * the order of elements returned by next should be: [1,2,3,4,5,6].
// */
//public class Vector2D implements Iterator<Integer> {
//    List<List<Integer>> vec2d;
//    int index1;
//    int index2;
//
//    public Vector2D(List<List<Integer>> vec2d) {
//        this.vec2d = vec2d;
//        this.index1 = 0;
//        this.index2 = 0;
//    }
//
//    @Override
//    public Integer next() {
//        if (hasNext()) {
//            return vec2d.get(index2).get(index1++);
//        }
//        return 0;
//    }
//
//    @Override
//    public boolean hasNext() {
//        while (index2 < vec2d.size()) {
//            if (index1 < vec2d.get(index2).size()) {
//                return true;
//            } else {
//                index2++;
//                index1 = 0;
//            }
//        }
//        return false;
//    }
//}