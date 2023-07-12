class pair {
  int row;int col;int tm;
  pair(int _row, int _col, int _tm) {
    this.row = _row;
    this.col = _col;
    this.tm = _tm;
  }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        Queue<pair> q= new LinkedList<>();
        
        int vis[][]=new int [n][m];
        int fresh=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new pair(i,j,0));
                    vis[i][j]=2;
                }
                else
                    vis[i][j]=0;
                
                if(grid[i][j]==1)
                    fresh++;
            }
        }
        int time=0;
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        int cnt=0;
        
    while (!q.isEmpty()) 
    {
        int r=q.peek().row;
        int c=q.peek().col;
        int t=q.peek().tm;
        
        time=Math.max(time,t);
        q.remove();
        
        //4 neighbour
        
        for(int i=0;i<4;i++)
        {
            int nrow=r+drow[i];
            int ncol=c+dcol[i];
            //check coordinates
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1)
            {
                q.add(new pair(nrow,ncol,t+1));
                vis[nrow][ncol]=2;
                cnt++;
            }
        }
    }
        if(cnt!=fresh)
            return -1;
        
        return time;
            
    }
}