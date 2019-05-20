package heap;

import java.util.*;

//218. The Skyline Problem

//A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
// Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A),
// write a program to output the skyline formed by these buildings collectively (Figure B).

//The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
// where Li and Ri are the x coordinates of the left and right edge of the ith building,
// respectively,
// and Hi is its height.

// It is guaranteed that 0 ≤ Li,
// Ri ≤ INT_MAX,
// 0 < Hi ≤ INT_MAX,
// and Ri - Li > 0.

// You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
//
//        For instance,
// the dimensions of all buildings in Figure A are recorded as:
// [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

//        The output is a list of "key points"
// (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ]
// that uniquely defines a skyline.
// A key point is the left endpoint of a horizontal line segment.
// Note that the last key point, where the rightmost building ends,
// is merely used to mark the termination of the skyline,
// and always has zero height.
// Also,
// the ground in between any two adjacent buildings should be considered part of the skyline contour.
//
//        For instance,
// the skyline in Figure B should be represented as:
// [ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
//
//        Notes:
//
//        The number of buildings in any input list is guaranteed to be in the range [0, 10000].
//        The input list is already sorted in ascending order by the left x position Li.
//        The output list must be sorted by the x position.
//        There must be no consecutive horizontal lines of equal height in the output skyline.
// For instance,
// [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable;
// the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]


/**
 * Sweep Line
 * - avoid updating unnecessary points, we sweep the points from left to right
 * - need to know the highest building each time
 start point of a building: insert the building
 end point of a building: remove the building
 get the height: highest building
   - So we decide to use maxHeap, but need to handle the remove operation
 * Runtime: 169 ms
 * Memory Usage: 45.8 MB
 * Time: O(nlogn)
 * each building is offered and polled from maxheap just once
 * Space: O(n)
 */
public class TheSkylineProblem {
    // Each building is spitted to Two Points
    class Point {
        int pos;
        int height; // if true, the point is a start point, otherwise an end point

        Point(int pos, int height) {
            this.pos = pos;
            this.height = height;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0] == null || buildings[0].length == 0) {
            return result;
        }
        PriorityQueue<Point> queue = new PriorityQueue<>(((o1, o2) -> o1.pos == o2.pos? o1.height - o2.height : o1.pos - o2.pos));
        for (int[] build : buildings) { // O(nlogn)
            queue.add(new Point(build[0], -build[2]));
            queue.add(new Point(build[1], build[2]));
        }
        PriorityQueue<Integer> maxHeightHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeightHeap.offer(0);
        int prevPeak = maxHeightHeap.peek();
        while(!queue.isEmpty()) {
            Point point = queue.poll();  // O(logn)
            if (point.height < 0) {
                // start point
                // add the building
                maxHeightHeap.offer(-point.height);
            } else {
                // end point
                // remove the building
                maxHeightHeap.remove(point.height);
            }
            int currPeak = maxHeightHeap.peek();//get the current max height
            if (currPeak != prevPeak) {
                // the current max height is changed at this point
                // then this point is the key point
                List<Integer> keyPoint = new ArrayList<>();
                keyPoint.add(point.pos);
                keyPoint.add(currPeak);
                result.add(keyPoint);
                prevPeak = currPeak;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TheSkylineProblem ins = new TheSkylineProblem();
        int[][] buildings = new int[][] {
                {2, 9, 10},
                {3,7,15},
                {5,12,12},
                {15,20,10},
                {19,24,8}
        };
        ins.getSkyline(buildings);
    }
}
