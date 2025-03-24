//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().matrixMultiplication(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int dp[][]= new int[n][n];
        
         for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for(int len =2;len<n;len++)
        {
            for(int i=0;i<n-len;i++)
            {
                int j = i+len;
                dp[i][j]= Integer.MAX_VALUE;
                
                for(int k=i+1;k<j;k++)
                {
                    int cost=dp[i][k]+dp[k][j]+arr[i]*arr[j]*arr[k];
                    dp[i][j]=Math.min(dp[i][j],cost);
                }
                
            }
        }
       return dp[0][n-1];
    }
}