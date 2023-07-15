class tuple{
    int distance;
    int row;
    int col;
    public tuple(int distance,int row, int col){
        this.row = row;
        this.distance = distance;
        this.col = col; 
    }
}
class Solution {
    
  public int minimumEffortPath(int[][] heights) {
        PriorityQueue<tuple> pq = new PriorityQueue<tuple>((x,y) -> x.distance - y.distance);
        int n=heights.length;
        int m=heights[0].length;
        
        int dist[][]=new int[n][m];
        for(int i = 0;i<n;i++) 
            for(int j = 0;j<m;j++) 
                dist[i][j] = (int)(1e9); 
        
        dist[0][0] = 0; 
        pq.add(new tuple(0, 0, 0)); 
        int dr[]={-1,0,1,0};
        int dc[]={0,1,0,-1};
        
        while(!pq.isEmpty())
        {
            tuple it = pq.peek(); 
            pq.remove(); 
            int diff=it.distance;
            int r=it.row;
            int c=it.col;
            
            if(r==n-1 && c==m-1)
            return diff;
            
            for(int i=0;i<4;i++)
            {
             int newr=r+dr[i];
             int newc=c+dc[i];
             
             if(newr>=0 && newr<n && newc>=0 && newc<m)
             {
                 int neweffort=Math.max(Math.abs(heights[r][c]-heights[newr][newc]),diff);
                 if(neweffort<dist[newr][newc])
                 {
                     dist[newr][newc]=neweffort;
                     pq.add(new tuple(neweffort,newr,newc));
                 }
             }
            }
        }
        return -1;
    }
} 