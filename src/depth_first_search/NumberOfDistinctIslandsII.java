package depth_first_search;
//Given a non-empty 2D array grid of 0's and 1's,
// an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
// You may assume all four edges of the grid are surrounded by water.
//
//        Count the number of distinct islands.
// An island is considered to be the same as another if they have the same shape,
// or have the same shape after rotation (90, 180, or 270 degrees only)
// or reflection (left/right direction or up/down direction).
//
//        Example 1:
//        11000
//        10000
//        00001
//        00011
//        Given the above grid map, return 1.
//
//        Notice that:
//        11
//        1
//        and
//        1
//        11
//        are considered same island shapes.
// Because if we make a 180 degrees clockwise rotation on the first island,
// then two islands will have the same shapes.
//
//        Example 2:
//        11100
//        10001
//        01001
//        01110
//        Given the above grid map, return 2.
//
//        Here are the two distinct islands:
//        111
//        1
//        and
//        1
//        1
//
//        Notice that:
//        111
//        1
//        and
//        1
//        111
//        are considered same island shapes.
// Because if we flip the first array in the up/down direction,
// then they have the same shapes.
//        Note: The length of each dimension in the given grid does not exceed 50.

//Approach #1: Canonical Hash [Accepted]
//        Intuition
//
//        As in Approach #1 to the sister problem Number of Distinct Islands,
// we determine local coordinates for each island.
//
//        Afterwards,
// we will rotate and reflect the coordinates about the origin and translate the shape
// so that the bottom-left-most coordinate is (0, 0).
// At the end,
// the smallest of these lists coordinates will be the canonical representation of the shape.
//
//        Algorithm
//
//        We feature two different implementations,
// but the core idea is the same.
// We start with the code from the previous problem,
// Number of Distinct Islands.
//
//        For each of 8 possible rotations and reflections of the shape,
// we will perform the transformation and then translate the shape so that the bottom-left-most coordinate is (0, 0).
// Afterwards,
// we will consider the canonical hash of the shape to be the maximum of these 8 intermediate hashes.
//
//        In Python,
// the motivation to use complex numbers is that rotation by 90 degrees is the same as multiplying by the imaginary unit, 1j.
// In Java,
// we manipulate the coordinates directly.
// The 8 rotations and reflections of each point are (x, y), (-x, y), (x, -y), (-x, -y), (y, x), (-y, x), (y, -x), (-y, -x).
public class NumberOfDistinctIslandsII {
    public int numDistinctIslands2(int[][] grid) {
        return 0;
    }
}
