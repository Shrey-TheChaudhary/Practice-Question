//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Directions for moving in the grid
    private int[] dRow = {-1, 1, 0, 0};
    private int[] dCol = {0, 0, -1, 1};

    // Function to return the minimum cost to reach the bottom-right cell from the top-left cell.
    public int minimumCostPath(int[][] grid) {
        int N = grid.length;
        int[][] dist = new int[N][N];

        // Initialize the distance array with a large value
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Min-Heap priority queue to store cells and their current path cost
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        // Start from the top-left corner
        pq.add(new Cell(0, 0, grid[0][0]));
        dist[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int row = current.row;
            int col = current.col;
            int currentCost = current.cost;

            // If we reached the bottom-right corner, return the cost
            if (row == N - 1 && col == N - 1) {
                return currentCost;
            }

            // Explore the 4 possible directions
            for (int i = 0; i < 4; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                // Check if the new position is within the grid bounds
                if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N) {
                    int newCost = currentCost + grid[newRow][newCol];

                    // If a cheaper cost path is found
                    if (newCost < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newCost;
                        pq.add(new Cell(newRow, newCol, newCost));
                    }
                }
            }
        }

        // Return the minimum cost to reach the bottom-right corner
        return dist[N-1][N-1];
    }

    // Class to represent a cell in the grid with its row, col, and cost
    class Cell {
        int row, col, cost;
        Cell(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
}

