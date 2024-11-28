class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Priority queue to implement Dijkstra's algorithm
        PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        pq.offer(new Tuple(0, 0, grid[0][0]));

        // Directions for moving up, down, left, and right
        int[] rowP = {-1, 0, 0, 1};
        int[] colP = {0, -1, 1, 0};

        // Visited array to keep track of visited cells
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Tuple cur = pq.poll();
            int row = cur.row;
            int col = cur.col;
            int k = cur.val;

            // If we've reached the bottom-right corner, return the number of obstacles removed
            if (row == n - 1 && col == m - 1) {
                return k;
            }

            // Explore the 4 possible directions
            for (int i = 0; i < 4; i++) {
                int nr = row + rowP[i];
                int nc = col + colP[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.offer(new Tuple(nr, nc, k + grid[nr][nc]));
                }
            }
        }

        // If no path found, return -1 (this case should not occur with given constraints)
        return -1;
    }

    class Tuple {
        int row;
        int col;
        int val;
        Tuple(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
