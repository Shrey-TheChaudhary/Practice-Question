class Solution {
    public int uniquePathsWithObstacles(int[][] maze) {
        int m=maze.length;
        int n=maze[0].length;
        int[][] dp =  new int [m][n];
        
        for(int[] row : dp)
        Arrays.fill(row, -1);
    
    return allpath(m-1, n-1, maze, dp);
}
 static int allpath(int i, int j, int[][] maze, int[][] dp){
    if (i == 0 && j == 0) {
        if (maze[i][j] == 1) {
            return 0;
        }
        return 1;
    }
    if(i<0 || j<0)return 0;
    if(maze[i][j]==1)return 0;

    if(dp[i][j]!=-1) return dp[i][j];
    
    int up = maze[i][j] + allpath(i-1, j, maze, dp);
    int left = maze[i][j] + allpath(i, j-1, maze, dp);
    
    int count = up + left;
    
    return dp[i][j] = count;
    } 
}