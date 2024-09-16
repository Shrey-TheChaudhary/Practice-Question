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
            int newrow=row+delrow[i];
            int newcol=col+delcol[i];
            
            if(newrow>=0 && newcol>=0 && newrow<n && newcol<m && image[newrow][newcol]==inicolor && ans[newrow][newcol]!=color)
            {
                dfs(newrow,newcol,ans,image,color,delrow,delcol,inicolor);
            }
        }
    }
}