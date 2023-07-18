class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        
        int dp[][]=new int [n][n];
        
        for(int j=0;j<n;j++)
            dp[0][j]=matrix[0][j];
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int up=matrix[i][j]+dp[i-1][j];
                
                int leftdig=matrix[i][j];
                if(j-1>=0)
                    leftdig+=dp[i-1][j-1];
                else
                    leftdig+=(int)Math.pow(10,9);
                
                 int rightdig=matrix[i][j];
                if(j+1<n)
                    rightdig+=dp[i-1][j+1];
                else
                    rightdig+=(int)Math.pow(10,9);
                
                dp[i][j]=Math.min(up,Math.min(leftdig,rightdig));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            min=Math.min(min,dp[n-1][i]);
        
        return min;
    }
}