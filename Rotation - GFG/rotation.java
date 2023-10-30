//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    //Striver:find the index of minimum element in an array that many times the array has been rotated
    int findKRotation(int arr[], int n) {
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            //search space is already sortedt then arr[low] will always be the minimum in that search space:
          
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break;
            }

            //if left part is sorted:keep the minimum:
            if (arr[low] <= arr[mid]) 
            {
                if (arr[low] < ans)
                {
                    index = low;
                    ans = arr[low];
                }
                // Eliminate left half:
                low = mid + 1;
            } 
            else 
            { //if right part is sorted:keep the minimum:
                if (arr[mid] < ans) 
                {
                    index = mid;
                    ans = arr[mid];
                }
                // Eliminate right half:
                high = mid - 1;
            }
        }
        return index;
    }
}