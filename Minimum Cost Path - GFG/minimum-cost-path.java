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


class Solution
{
  
class Pair{
    int r1,c1,d1;
    public Pair(int a,int b,int c)
    {
        this.r1=a;
        this.c1=b;
        this.d1=c;
    }
}
    public int minimumCostPath(int[][] grid)
    {
    int n =grid.length;
    int m=grid[0].length;
     int d[][]=new int[n][m];
     for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                d[i][j]=Integer.MAX_VALUE;
                
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.d1-b.d1);
        d[0][0]=grid[0][0];
        
     int dx[] = { -1, 0, 1, 0 };
    int dy[] = { 0, 1, 0, -1 };
  
 pq.add(new Pair(0,0,d[0][0]));
   
     while(!pq.isEmpty())
     {
         Pair t=pq.poll();
         int r=t.r1;
         int c=t.c1;
         int dis=t.d1;
         for(int i=0;i<4;i++)
         {
             int nr=r+dx[i];
             int nc=c+dy[i];
             if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                 if(dis+grid[nr][nc]<d[nr][nc])
                 {
                   
                     d[nr][nc]=dis+grid[nr][nc];
                     pq.offer(new Pair(nr,nc,d[nr][nc]));
                     
                 }
             }
         }
     }
    
     return d[n-1][m-1];
       
    }
}