import java.util.*;
class Solution {
    public void fill(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> stack = new ArrayDeque<>();

        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 'O') {
                visited[i][0] = true;
                stack.push(new int[]{i, 0});
            }
            if (grid[i][n - 1] == 'O') {
                visited[i][n - 1] = true;
                stack.push(new int[]{i, n - 1});
            }
        }

        for (int j = 1; j < n - 1; j++) {
            if (grid[0][j] == 'O') {
                visited[0][j] = true;
                stack.push(new int[]{0, j});
            }
            if (grid[m - 1][j] == 'O') {
                visited[m - 1][j] = true;
                stack.push(new int[]{m - 1, j});
            }
        }

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int x = cell[0], y = cell[1];
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 'O' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    stack.push(new int[]{nx, ny});
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'O' && !visited[i][j]) {
                    grid[i][j] = 'X';
                }
            }
        }
    }
}