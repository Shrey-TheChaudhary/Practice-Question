//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        // Determine the low and high bounds for binary search
        int low = 0, high = 0;
        for (int num : arr) {
            high += num;
            low = Math.max(low, num);
        }

        // Binary search to find the minimum possible maximum subarray sum
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canSplit(arr, N, K, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean canSplit(int[] arr, int N, int K, int maxSum) {
        int sum = 0, count = 1;
        for (int num : arr) {
            if (sum + num > maxSum) {
                sum = 0;
                count++;
            }
            sum += num;
            if (count > K) {
                return false;
            }
        }
        return true;
    }
};