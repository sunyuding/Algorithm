package backtracking;

public class PermutationSequence {
    /**
     * Time: (ok)
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        for(int i = 1; i < k; i++) {
            nextPermutation(nums);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // i < 0 or  nums[i] < nums[i + 1]
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
