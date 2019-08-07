package quick_select;

/**
 * Time:
 * O(n)
 * The expected time complexity of randomized QuickSelect is O(n).
 * However, the worst time complexity still remains O(n^2).
 *
 * Space:
 * average O(logn) worst O(n) for recursion
 * O(1) for iteration
 */
public class KthSmallest {
    public int kthSmallest(int[] array, int k) {
        return kth(array, k, 0, array.length - 1);
    }

    private int kth(int[] array, int k, int left, int right) {
//        int pivotIndex = randomPartition(array, left, right); // pivot index
////        if (k - 1 == pivotIndex) {
////            return pivotIndex;
////        } else if (k - 1 > pivotIndex) {
////            return kth(array, k, pivotIndex + 1, right);
////        } else {
////            return kth(array, k, left, pivotIndex - 1);
////        }

        while(left <= right) {
            int pivotIndex = randomPartition(array, left, right);
            if (k - 1 == pivotIndex) {
                return pivotIndex;
            } else if (k - 1 > pivotIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
        return -1;
    }

    private int randomPartition(int[] array, int left, int right) {
        int n = right - left + 1;
        int pivot = (int) (Math.random() * n);
        swap(array, left + pivot, right);
        return partition(array, left, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right], i = left;
        for (int j = left; j <= right - 1; j++) {
            if (array[j] <= pivot) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, right);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
