//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


class Solution {
    public long count(int coins[], int N, int sum) {
        long dp[][]=new long[N][sum+1];
        for(int i=0;i<=sum;i++)
        {
            if(i%coins[0]==0)
            dp[0][i]=1;
        }
        for(int ind=1;ind<N;ind++)
        {
            for(int target=0;target<=sum;target++)
            {
            long nottaken=dp[ind-1][target];

            long taken=0;
            if(coins[ind]<=target)
            taken=dp[ind][target-coins[ind]];
            
            dp[ind][target]=taken+nottaken;
        }
        }
    return dp[N-1][sum];
    }
}