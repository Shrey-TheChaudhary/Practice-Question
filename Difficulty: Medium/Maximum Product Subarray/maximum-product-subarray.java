//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        int n=arr.length;
        int leftCurrent=1;
        int rightCurrent=1;
        int max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            leftCurrent *=arr[i];
            rightCurrent *=arr[n-i-1];
            max=Math.max(Math.max(leftCurrent,max),rightCurrent);
            if(leftCurrent==0) leftCurrent=1;
            if(rightCurrent==0) rightCurrent=1;
        }
        return max;
    }
}