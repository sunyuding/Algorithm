//import java.util.Iterator;
//
//// Java Iterator interface reference:
//// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
//class PeekingIterator implements Iterator<Integer> {
//    Iterator<Integer> iterator;
//    boolean peeked;
//    Integer cur;
//
//    public PeekingIterator(Iterator<Integer> iterator) {
//        // initialize any member here.
//        this.iterator = iterator;
//    }
//
//    // Returns the next element in the iteration without advancing the iterator.
//    public Integer peek() {
//        if (peeked) {
//            return cur;
//        }
//        cur = iterator.next();
//        peeked = true;
//        return cur;
//    }
//
//    // hasNext() and next() should behave the same as in the Iterator interface.
//    // Override them if needed.
//    @Override
//    public Integer next() {
//        if (peeked) {
//            peeked = false;
//            return cur;
//        }
//        return iterator.next();
//    }
//
//    @Override
//    public boolean hasNext() {
//        if (peeked) {
//            return true;
//        }
//        return iterator.hasNext();
//    }
//}