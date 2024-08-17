//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        long p=1;
        int zeroCount = 0;
        long[] ans = new long[nums.length];
        
        //find product of array elements
        for(int num : nums){
            //if more than 1 '0' occur, fill array with '0'
            if(zeroCount > 1){
                Arrays.fill(ans, 0);
                return ans;
            }
            if(num == 0){
                zeroCount++;
            } else {
                p *= num;
            }
        }
        
        //if more than 1 '0' occur, fill array with '0'
        if(zeroCount > 1){
            Arrays.fill(ans, 0);
            return ans;
        }
        
        //if only 1 '0' occurs, swap
        if(zeroCount == 1){
            Arrays.fill(ans, 0);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    ans[i] = p;
                }
            }
        }    
        //else, fill array with product p
        else {
            for(int i=0; i<nums.length; i++){
                ans[i] = p/nums[i];
            }
        }
        
        return ans;
    }
}