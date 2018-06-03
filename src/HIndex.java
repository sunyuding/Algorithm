import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher,
 * write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
 *
 * Example:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 *              received 3, 0, 6, 1, 5 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index
 *
 *
 */
public class HIndex {
    /**
     * Given an integer array
     * find the largest number x in the array
     * such that there are at least x numbers >= x in the array
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        return 0;
    }

    /**
     * for each of the element x in the array,
     * calculate the # of elements that >= x
     * (iterate the whole array)
     * O(n^2)
     *
     * optimize it a little bit
     * if the array is sorted,
     * then we can use O(1) to get the # of elements that >= x
     * O(n)
     *
     * further optimize it using binary search
     * O(logn)
     *
     * if the array is not sorted,
     * sort the array first
     * O(nlogn)
     *
     * @param citations
     * @return
     */
    private int binarySearch(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        //[3,0,6,1,5]
        //[0,1,3,5,6]
        // 5 4 3 2 1
        // run binary search to find the largest i that
        // length - i >= citations(i)
        int lo = 0, hi = citations.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (citations[mid] < citations.length - mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (citations[lo] < citations.length - lo) {
            return 0;
        }
        return citations.length - lo;
    }

    /**
     * If the array is not sorted
     *
     * Quick Select
     * related to the position after sorted
     * if array[pivot] <= array.length - pivot: go right
     * else:                                    go left
     *
     * @param citations
     * @return the index of x
     */
    private int quickSelect(int[] citations) {
        return 0;
    }
}
