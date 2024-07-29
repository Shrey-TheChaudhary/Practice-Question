//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int ans=-1,ones=0,n=arr.length,m=arr[0].length;
        for(int i=0;i<arr.length;i++){
            int l=0,r=m-1,lo=-1;
            while(l<=r){
                int mid=(l+r)/2;
                if(arr[i][mid]==1){
                    lo=mid;
                    r=mid-1;
                }
                else l=mid+1;
            } 
            if(lo!=-1 && m-lo>ones){
                ones=m-lo;
                ans=i;
            }
        }
        return ans;
    }
}