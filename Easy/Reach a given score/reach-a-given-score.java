//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends


// Complete this function!

class Geeks {
    public long count(int n) {
        int[] arr = new int[]{3 , 5 , 10};
        /*long[][] dp = new long[3][n + 1];
        for(long[] d:dp) {
            Arrays.fill(d , -1);
        }*/
        return solveOpti(n , arr);
    }
    public long solveOpti(int m , int[] arr) {
        long[] next = new long[m + 1];
        for(int ind=2; ind>=0; ind--) {
            long[] curr = new long[m + 1];
            next[0] = curr[0] = 1;
            for(int n=1; n<=m; n++) {
                long incl = 0 , excl = 0;
                if(n - arr[ind] >= 0) {
                    incl = curr[n - arr[ind]];
                }
                excl = next[n];
                curr[n] = incl + excl;
            }
            next = curr;
        }
        return next[m];
    }
    public long solveDp2(int m , int[] arr) {
        long[][] dp = new long[4][m + 1];
        for(int ind=0; ind<=3; ind++) {
            dp[ind][0] = 1;
        }
        for(int ind=2; ind>=0; ind--) {
            for(int n=1; n<=m; n++) {
                long incl = 0 , excl = 0;
                if(n - arr[ind] >= 0) {
                    incl = dp[ind][n - arr[ind]];
                }
                excl = dp[ind + 1][n];
                dp[ind][n] = incl + excl;
            }
        }
        return dp[0][m];
    }
    public long solveDp(int ind , int n , int[] arr , long[][] dp) {
        if(ind >= arr.length) {
            if(n == 0) {
                return 1;
            }
            return 0;
        }
        if(dp[ind][n] != -1) {
            return dp[ind][n];
        }
        long incl = 0 , excl = 0;
        if(n - arr[ind] >= 0) {
            incl = solveDp(ind , n - arr[ind] , arr , dp);
        }
        excl = solveDp(ind + 1 , n , arr , dp);
        return dp[ind][n] = incl + excl;
    }
    public long solveRec(int ind , int n , int[] arr) {
        if(ind >= arr.length) {
            if(n == 0) {
                return 1;
            }
            return 0;
        }
        long incl = 0 , excl = 0;
        if(n - arr[ind] >= 0) {
            incl = solveRec(ind , n - arr[ind] , arr);
        }
        excl = solveRec(ind + 1 , n , arr);
        return incl + excl;
    }
}