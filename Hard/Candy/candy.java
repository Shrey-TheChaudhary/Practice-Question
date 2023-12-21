//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minCandy(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minCandy(int N, int ratings[]) {
        // Create an array to store the number of candies for each child.
        int[] nums = new int[ratings.length];
        
        // Initialize each child with 1 candy.
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 1;
        }
        
        // Traverse the ratings array from left to right.
        for (int i = 1; i < nums.length; i++) {
            // If the current child has a higher rating than the previous one,
            // give them one more candy than the previous child.
            if (ratings[i] > ratings[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            }
        }
        
        // Traverse the ratings array from right to left.
        for (int i = nums.length - 1; i >= 1; i--) {
            // If the rating of the previous child is higher than the current one,
            // and the number of candies for the previous child is not greater
            // than or equal to the current child, update the candies for the previous child.
            if (ratings[i - 1] > ratings[i] && nums[i - 1] <= nums[i]) {
                nums[i - 1] = nums[i] + 1;
            }
        }
        
        // Calculate the total sum of candies given to all children.
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        
        // Return the total sum of candies.
        return sum;
    }
}