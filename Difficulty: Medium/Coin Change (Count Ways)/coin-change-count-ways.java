//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(arr, sum));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    public int count(int coins[], int sum) {
        // code here.
        // return f(new Integer[coins.length][sum+1],coins,coins.length-1,sum);
        // return f(coins,sum);
        return fOpt(coins,sum);
    }
    
    int f(Integer dp[][],int coins[],int i,int sum){
       if(sum<0) return 0;
       if(i<0){
           return sum==0?1:0;
       }
       if(dp[i][sum]!=null) return dp[i][sum];
          int count =0;
       
          if(sum- coins[i]>=0){
             count+=f(dp,coins,i,sum-coins[i]); 
          }
          count+=f(dp,coins,i-1,sum);
       
       return dp[i][sum]=count;
    }
    
    int f(int coins[],int sum){
        int dp[][]=new int[coins.length][sum+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
               int count =0;
               if(j-coins[i]>=0){
                   count+=(j-coins[i] <0 ?0:  dp[i][j-coins[i]]);
               }
               count+= (i-1<0 ?(j==0 ? 1:0) : dp[i-1][j]);
               dp[i][j]=count;
            }
        }
        
        return dp[coins.length-1][sum];
    }
    
    int fOpt(int coins[],int sum){
        int prev[]=new int[sum+1];
        int curr[]=new int[sum+1];
        
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<sum+1;j++){
               int count=0;
               if(j-coins[i]>=0){
                   count+=(j-coins[i]<0?0:curr[j-coins[i]]);
               }
               count+=(i-1<0?(j==0?1:0):prev[j]);
               curr[j]=count;
            }
            int t[]= prev;
            prev=curr;
            curr=t;
        }
        
        return prev[sum];
    }
}