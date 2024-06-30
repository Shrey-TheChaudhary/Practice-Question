class Solution {
    class UnionFind {
        int[] parent;
        int[] rank;
        int count;
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
                return true;
            }
            return false;
        }
        public int getCount() {
            return count;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind aliceUF = new UnionFind(n);
        UnionFind bobUF = new UnionFind(n);
        int addedEdges = 0;
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);
        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1] - 1;
            int v = edge[2] - 1;

            if (type == 3) {
                boolean aliceConnected = aliceUF.union(u, v);
                boolean bobConnected = bobUF.union(u, v);
                if (aliceConnected || bobConnected) {
                    addedEdges++;
                }
            } else if (type == 1) {
                if (aliceUF.union(u, v)) {
                    addedEdges++;
                }
            } else if (type == 2) {
                if (bobUF.union(u, v)) {
                    addedEdges++;
                }
            }
        }
        if (aliceUF.getCount() > 1 || bobUF.getCount() > 1) {
            return -1;
        }
        return edges.length - addedEdges;
    }
	}