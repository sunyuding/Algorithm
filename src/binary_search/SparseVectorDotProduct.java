package binary_search;
//具体而言，我有两个vector a:[0, 0, 0, 0, a1, 0, 0, 0….a2, 0, 0….], b:[0, 0, 0, 0, b1, 0, 0…..],你可以看到有很多0，所以如果我们直接一个个乘是很浪费时间的，所以你可以设计一个数据结构来存储这些系数矩阵并高效地想乘，
//
//        hash map挺浪费的，直接用list(tuple)存就行，tuple->（value,index）
//        如果都是sparse vectors,那思路就是把每个vector都表示成(index, non-zero value) pairs:
//        A =[0,2,0,2,0,0,3,0,0,4] ==> A={(1,2), (3,2), (6,3), (9,4)}
//        B=[0,0,0,0,5,0,2,0,0,8] ==> B={(4,5), (6,2), (9,8)}
//
//        for each index i, a = val of pair (i, v_in_A), b= val of pair (i, v_in_B). visit 1point3acres.com for more.
//        dot_product(A,B) = sum_of ( a * b )
//        A dot product B = 3*2 + 4*8 = 38
//
//        follow-up：
//        what if the number of nonzero elements of one vector is 10^10 and the other is 10^2, how can you make it faster?
//
//        follow-up:
//        follow up问有没有更简单的数据结构，我答的是array存index和value。
//
//Dot Product.
//        A={a1, a2, a3,…}.
//        B={b1, b2, b3,…}
//        dot_product = a1 * b1 + a2 * b2 + a3 * b3 ＋。。。
//        如果数组很稀疏，例如
//        A={a1, …., a300, …., a5000}
//        B={…., b100, …, b300, …, b1000, …}
//        里面有很多0，用什么数据结构表示能节省空间。我开始说用hashmap，但是hashmap不能做有顺序的iteration。然后改用list和array，两个都可以。后面做题的时用的array。
//        题目是：
//input A=[[1, a1], [300, a300], [5000, a5000]]
//        B=[[100, b100], [300, b300], [1000, b1000]]
//        求 dot product. 问了时间复杂度。
//        Follow up:
//如果length(B) >>> length(A)，即B非常长，怎么做能减少时间复杂度。对A里面的每个数，用binary search找B中相对应的值，这样时间复杂度是O(nlogm) (n = len(A), m =len(B)).时间不够没写代码， 就说了一下思路和复杂度

import java.util.ArrayList;

/**
 * Follow-up:
 * What if one of the array has very small number of non-zeros
 * the other one has a lot of non-zeros?
 * We need to reduce the impact of n1(dominate) --> binary search --> O(log n1)
 * Time: O(n2 * logn1)
 */
public class SparseVectorDotProduct {
    private class Pair {
        int index;
        int value;
    }

    // index, value
    // O(a.length + b.length)
    public int dotproduct(ArrayList<Pair> a, ArrayList<Pair> b){
        int dotSum = 0;

        for (int i = 0; i < a.size(); i++) {
            int start = 0;
            int end = b.size();
            while(start < end) {
                int mid = start + (end - start) / 2;
                Pair ap = a.get(i);
                Pair bp = b.get(mid);
                if (ap.index == bp.index) {
                    dotSum += ap.value * bp.value;
                } else if (ap.index < bp.index) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return dotSum;
    }
}
