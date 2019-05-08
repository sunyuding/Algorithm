package binary_search;

public class MedianOfTwoSortedArrays {
    /**
     * Time: O(log(min of (m, n)))\
     * Space: O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { // to ensure m<=n
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        // search i from 0 to m
        // find a position where nums1[i - 1] <= nums2[j] && nums1[i] >= nums2[j - 1]
        int imin = 0;
        int imax = m;
        while (imin <= imax) {
            int i = imin + (imax - imin) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j - 1 > 0 && nums2[j-1] > nums1[i]){
                imin = i + 1; // i is too small
            } else if (i > imin && nums1[i-1] > nums2[j]) {
                imax = i - 1; // i is too big
            } else {// i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j-1];
                } else if (j == 0) {
                    maxLeft = nums1[i-1];
                } else {
                    maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                }

                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
