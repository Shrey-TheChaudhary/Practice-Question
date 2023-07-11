class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length;
        int n=mat[0].length;
        if(m*n!=r*c)
            return mat;
        
        int res[][]=new int[r][c];
        int row=0,col=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(col==n)
                {
                    row++;
                    col=0;
                }
                res[i][j]=mat[row][col];
                col++;
            }
        }
        return res;
    }
}