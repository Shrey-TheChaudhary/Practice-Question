class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int inicolor=image[sr][sc];
        int ans[][]=image;
        
        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};
        dfs(sr,sc,ans,image,color,delrow,delcol,inicolor);
        
        return ans;
    }
    public void dfs(int row,int col,int ans[][],int image[][],int color,int delrow[],int delcol[],int inicolor)
    {
        ans[row][col]=color;
        int n=image.length;
        int m=image[0].length;
        
        for(int i=0;i<4;i++)
        {
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==inicolor && ans[nrow][ncol]!=color)
            {
            dfs(nrow,ncol,ans,image,color,delrow,delcol,inicolor);
            }
        }
    }
}