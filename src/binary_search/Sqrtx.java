package binary_search;

public class Sqrtx {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        if (x == 1) return 1;
        int l = 1;
        int r = x;
        while(l < r - 1) { //
            int mid = l + (r - l) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (x / mid < mid) {
                r = mid;
            } else {
                //
                l = mid;
            }
        }
        // l == r - 1
        if (r <= x / r) {
            return r;
        } else {
            return l;
        }
    }
}
