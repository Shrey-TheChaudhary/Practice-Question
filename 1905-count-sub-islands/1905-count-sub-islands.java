import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second; 
    
    public Pair(int first, int second) {
        this.first = first; 
        this.second = second; 
    }
}

public class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length; 
        int m = grid1[0].length; 
        int[][] vis = new int[n][m];
        int cnt = 0; 

        for(int row = 0; row < n ; row++) {
            for(int col = 0; col < m ;col++) {
                // if not visited and is a land in grid2
                if(vis[row][col] == 0 && grid2[row][col] == 1) {
                    // Check if this island is a sub-island
                    if(bfs(row, col, vis, grid1, grid2)) {
                        cnt++; 
                    }
                }
            }
        }
        return cnt; 
    }

    private boolean bfs(int ro, int co, int[][] vis, int[][] grid1, int[][] grid2) {
        vis[ro][co] = 1; 
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co)); 
        int n = grid1.length; 
        int m = grid1[0].length; 
        boolean isSubIsland = true;

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        
        while(!q.isEmpty()) {
            int row = q.peek().first; 
            int col = q.peek().second; 
            q.remove(); 
            
            // If any part of the grid2 island is not in grid1, it's not a sub-island
            if(grid1[row][col] == 0) {
                isSubIsland = false;
            }

            for(int i = 0; i < 4; i++) {
                int nrow = row + delrow[i]; 
                int ncol = col + delcol[i]; 

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid2[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1; 
                    q.add(new Pair(nrow, ncol)); 
                }
            }
        }
        return isSubIsland;
    }
}