// class Pair {
//     int first;
//     int second; 
//     public Pair(int first, int second) {
//         this.first = first; 
//         this.second = second; 
//     }
// }
// class Solution {
//     public int numIslands(char[][] grid) {
//         int n = grid.length; 
//         int m = grid[0].length; 
//         int[][] vis = new int[n][m];
//         int cnt = 0; 
//         for(int row = 0; row < n ; row++) {
//             for(int col = 0; col < m ;col++) {
//                 // if not visited and is a land
//                 if(vis[row][col] == 0 && grid[row][col] == '1') {
//                     cnt++; 
//                     bfs(row, col, vis, grid); 
//                 }
//             }
//         }
//         return cnt; 
//     }
//       private void bfs(int ro, int co, int[][] vis, char[][] grid) {
//       vis[ro][co] = 1; 
//       Queue<Pair> q = new LinkedList<Pair>();
//       q.add(new Pair(ro, co)); 
//       int n = grid.length; 
//       int m = grid[0].length; 
      
//       // until the queue becomes empty
//       while(!q.isEmpty()) {
//           int row = q.peek().first; 
//           int col = q.peek().second; 
//           q.remove(); 
          
//           int delrow[]={-1,0,1,0};
//           int delcol[]={0,1,0,-1};
//          for(int i=0;i<4;i++)
//          {
//                   int nrow = row+delrow[i]; 
//                   int ncol = col+delcol[i]; 

//         if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) 
//         {
//                       vis[nrow][ncol] = 1; 
//                       q.add(new Pair(nrow, ncol)); 
//                   }
//               }
//           }
//       }
// }

class Solution {

    int rows;
    int cols;
    int island = 0;

    public int numIslands(char[][] grid) {

        rows=grid.length;
        cols=grid[0].length;

        for(int row = 0;row<rows;row++)
        {
            search(grid,row);
        }
        return island;

    }
    public void search(final char[][] grid,int row)
    {
        final char []finalrow = grid[row];

        for(int col = 0;col<cols;++col)
        {
            if(finalrow[col]=='1')
            {
                mark(grid,row,col);
                ++island;
            }
        }
    }

    public void mark(char[][] grid,int row,int col)
    {
        grid[row][col]='*';

        if(row>0 && grid[row-1][col]=='1')
            mark(grid,row-1,col);
        if(row+1<rows && grid[row+1][col]=='1')
            mark(grid,row+1,col);
        if(col>0 && grid[row][col-1]=='1')
            mark(grid,row,col-1);
        if(col+1<cols && grid[row][col+1]=='1')
            mark(grid,row,col+1);
    }
}
    