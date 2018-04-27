// Total Occurrence
// Description
// Given a target integer T and an integer array A sorted in ascending order,
// Find the total number of occurrences of T in A.
//
// Examples
//
// A = {1, 2, 3, 4, 5}, T = 3, return 1
// A = {1, 2, 2, 2, 3}, T = 2, return 3
// A = {1, 2, 2, 2, 3}, T = 4, return 0
// Corner Cases
//
// What if A is null? We should return 0 in this case.
// Medium
// Array
// Binary Search

public class TotalOccurrence {
    public int totalOccurrence(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return 0;
        }
        return binarySearch(array, target, 0, array.length - 1);
    }

    private int binarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return 0;
        }
        int mid = (left + right) / 2;
        if (array[mid] == target) {
            return 1 + binarySearch(array, target, left, mid - 1) + binarySearch(array, target, mid + 1, right);
        } else if (array[mid] < target) {
            return binarySearch(array, target, mid + 1, right);
        } else {
            return binarySearch(array, target, left, mid - 1);
        }
    }
}
