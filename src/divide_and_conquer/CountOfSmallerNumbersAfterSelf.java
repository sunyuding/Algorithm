package divide_and_conquer;

import java.util.LinkedList;
import java.util.List;

/**
 * Runtime: 5 ms
 * Memory Usage: 38.2 MB
 * Time: O(nlogn)
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        mergeSort(nums, index, 0, n - 1, res);

        List<Integer> list = new LinkedList<>();
        for (int i : res) {
            list.add(i);
        }
        return list;
    }

    private void mergeSort(int[] nums, int[] index, int l, int r, int[] res) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(nums, index, l, mid, res);
        mergeSort(nums, index, mid + 1, r, res);
        merge(nums, index, l, mid, mid + 1, r, res);
    }

    private void merge(int[] nums, int[] index, int l1, int r1, int l2, int r2, int[] res) {
        int start = l1;
        int[] tmp = new int[r2-l1+1];
        int p = 0;
        int count = 0; // right element count
        while (l1 <= r1 || l2 <= r2) {
            if (l1 > r1) {
                // left part is finished
                tmp[p++] = index[l2++];
            } else if (l2 > r2) {
                // right part is finished
                res[index[l1]] += count;
                tmp[p++] = index[l1++];
            } else if (nums[index[l1]] > nums[index[l2]]) {
                // right is smaller
                count++;
                tmp[p++] = index[l2++];
            } else {
                // left is smaller
                res[index[l1]] += count;
                tmp[p++] = index[l1++];
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            index[start+i] = tmp[i];
        }
    }


}
