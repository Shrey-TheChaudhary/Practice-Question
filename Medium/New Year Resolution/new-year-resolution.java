//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] coins = IntArray.input(br, N);
            
            Solution obj = new Solution();
            boolean res = obj.isPossible(N, coins);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends



class Solution {
    private static boolean solve(int arr[], int sum, int idx, Boolean dp[][]) {
        if(idx == arr.length)
            return sum != 0 && (sum % 20 == 0 || sum % 24 == 0 || sum == 2024);
        if((sum != 0 && (sum % 20 == 0) || (sum == 2024)))
            return true;
        if(dp[idx][sum] != null)    
            return dp[idx][sum];
        boolean pick = solve(arr, sum + arr[idx], idx+1, dp);
        boolean notpick = solve(arr, sum, idx+1, dp);
        return dp[idx][sum] = pick || notpick;
    }
    public static boolean isPossible(int N, int[] coins) {
        Boolean dp[][] = new Boolean[N+1][2025];
        return solve(coins, 0, 0, dp);
    }
}