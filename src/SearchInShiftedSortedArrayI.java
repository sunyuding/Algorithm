//Given a target integer T and an integer array A, A is sorted in ascending order first, then shifted by an arbitrary number of positions.
//
//        For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such that A[i] == T or return -1 if there is no such index.
//
//        Assumptions
//
//        There are no duplicate elements in the array.
//        Examples
//
//        A = {3, 4, 5, 1, 2}, T = 4, return 1
//        A = {1, 2, 3, 4, 5}, T = 4, return 3
//        A = {3, 5, 6, 1, 2}, T = 4, return -1
//        Corner Cases
//
//        What if A is null or A is of zero length? We should return -1 in this case.
// binary search

public class SearchInShiftedSortedArrayI {
    public int search(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return -1;
        }
        int minIndex = findMinIndex(array, 0, array.length - 1);
        if (minIndex == -1) {
            minIndex = 0;
        }
        if (array[minIndex] == target) {
            return minIndex;
        } else if (array[array.length - 1] >= target) {
            return binarySearch(array, target, minIndex + 1, array.length - 1);
        } else {
            return binarySearch(array, target, 0, minIndex - 1);
        }
    }

    private int findMinIndex(int[] array, int left, int right) {
        if (left > right) {
            return -1;
        } else if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (mid > 0 && array[mid] < array[mid - 1]) {
            return mid;
        } else if (array[mid] > array[right]) {
            return findMinIndex(array, mid + 1, right);
        } else {
            return findMinIndex(array, left, mid - 1);
        }
    };

    private int binarySearch(int[] array, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{};
        int target = 0;
        SearchInShiftedSortedArrayI SISSA = new SearchInShiftedSortedArrayI();
        int result = SISSA.search(array, target);
        System.out.println(result);
    }
}
