//Description
//Given a target integer T and an integer array A, A is sorted in ascending order first, then shifted by an arbitrary number of positions.
//
//For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index i such that A[i] == T or return -1 if there is no such index.
//
//Assumptions
//
//There could be duplicate elements in the array.
//Examples
//
//A = {3, 4, 5, 1, 2}, T = 4, return 1
//A = {3, 3, 3, 1, 3}, T = 1, return 3
//A = {3, 1, 3, 3, 3}, T = 1, return 1
//Corner Cases
//
//What if A is null or A is of zero length? We should return -1 in this case.
//Hard
//Array
//Binary Search

public class SearchInShiftedSortedArrayII {
    public int search(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return -1;
        }
        return binarySearch(array, target, 0, array.length - 1);

//        int minIndex = findMinIndex(array, 0, array.length - 1);
//        if (minIndex == -1) {
//            minIndex = 0;
//        }
//        if (array[minIndex] == target) {
//            return minIndex;
//        } else if (array[array.length - 1] >= target) {
//            return binarySearch(array, target, minIndex + 1, array.length - 1);
//        } else {
//            return binarySearch(array, target, 0, minIndex - 1);
//        }
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
            // left side
        } else if (array[mid] < array[right] || array[left] > array[mid]) {
            return findMinIndex(array, left, mid - 1);
            // left side
        } else if (array[mid] > array[left] || array[mid] > array[right]) {

            return findMinIndex(array, mid + 1, right);
        } else {
            return findMinIndex(array, left, --right);
        }
    };

    private int binarySearch(int[] array, int target, int left, int right) {
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            // find it
            if (array[mid] == target) {
                return mid;
            }

            //If we know for sure right side is sorted or left side is unsorted
            // min is in left side
            //  4 5 | 1 2 3

            if (array[mid] < array[left]) {
                if (target > array[mid] && target <= array[right]) {
                    // right side
                    left = mid + 1;
                } else {
                    // left side
                    right = mid - 1;
                }
                //If we know for sure left side is sorted or right side is unsorted
            } else if (array[mid] > array[left]) {
                if (target < array[mid] && target >= array[left]) {
//                    left side
                    right = mid - 1;
                } else {
                    // right side
                    left = mid + 1;
                }
                //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
                //any of the two sides won't change the result but can help remove duplicate from
                //consideration, here we just use end-- but left++ works too
            } else {
                // 3 3 3 1 3
                // not sure left side or right side is sorted
                left++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 3};
        int target = 1;
        SearchInShiftedSortedArrayII SISSA = new SearchInShiftedSortedArrayII();
        int result = SISSA.search(array, target);
        System.out.println(result);
    }
}
