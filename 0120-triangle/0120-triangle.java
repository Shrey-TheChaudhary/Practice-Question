// class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//       int n = triangle.size();
//         int dp[][] = new int[n][n];
//         for( int [] row : dp ){
//             Arrays.fill( row , -1 );
//         }
//         for( int i = 0 ; i < n ; i++ ){
//             dp[n-1][i] = triangle.get(n-1).get(i);
//         }
//         for(int i=n-2 ;i>=0;i--)
//         {
//             for(int j=0;j<=i;j++)
//             {
//                 int down=triangle.get(i).get(j)+dp[i+1][j];
//                 int dig=triangle.get(i).get(j)+dp[i+1][j+1];
                
//             dp[i][j] = Math.min(down,dig);
//             }
//         }
//         return dp[0][0];
//     }
// }

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int[][]val=new int[triangle.size()][triangle.size()];
        
        for(int row[]:val)
         Arrays.fill(row,-10001);
        
        return minpathsum(triangle,0,0,val);    
    }
    static int minpathsum(List<List<Integer>>triangle,int i,int j,int[][]val)
    {
        if(i==triangle.size())
         return 0;

        if(val[i][j]!=-10001) 
         return val[i][j];

       int a= triangle.get(i).get(j)+minpathsum(triangle,i+1,j,val);
       int b= triangle.get(i).get(j)+minpathsum(triangle,i+1,j+1,val);
        
       return val[i][j]=Math.min(a,b);

    }
}