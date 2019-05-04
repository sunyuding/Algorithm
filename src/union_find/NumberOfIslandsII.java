package union_find;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
    class UnionFind {
        private int[] id;
        int count;

        public UnionFind(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = -1;
            }
            count = 0;
        }

        public int root(int i) {
            while(i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        public boolean find(int p, int q) {
            return root(p) == root(q);
        }

        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            if (i != j) {
                count--;
            }
            id[i] = j;
        }
    }

    private boolean isValid(int m, int n, int i, int j) {
        return i >= 0 && j >= 0 && i <= m && j <= n;
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);
        for (int[] position : positions) {
            int i = position[0];
            int j = position[1];
            uf.count++;
            int id = i * n + j;
            uf.id[id] = id;
            if (isValid(m, n, i, j) && uf.id[id - 1] >= 0) uf.union(id, id - 1);
            if (isValid(m, n, i, j) && uf.id[id - n] >= 0) uf.union(id, id - n);
            if (isValid(m, n, i, j) && uf.id[id + 1] >= 0) uf.union(id, id + 1);
            if (isValid(m, n, i, j) && uf.id[id + n] >= 0) uf.union(id, id + n);
            result.add(uf.count);
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfIslandsII ins = new NumberOfIslandsII();
        int[][] positions = new int[][] {{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {0, 0}, {1, 1}};
        ins.numIslands2(3, 3, positions);
    }
}
