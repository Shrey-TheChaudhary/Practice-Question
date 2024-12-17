//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // Step 1: Sort the stalls
        Arrays.sort(stalls);

        // Step 2: Initialize binary search range
        int low = 1, high = stalls[stalls.length - 1] - stalls[0];
        int result = 0;

        // Step 3: Perform binary search
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Step 4: Check if placement is possible with 'mid' distance
            if (canPlaceCows(stalls, k, mid)) {
                result = mid; // Update result
                low = mid + 1; // Try for a larger distance
            } else {
                high = mid - 1; // Try for a smaller distance
            }
        }

        return result;
    }

    // Helper function to check if cows can be placed with at least 'distance' apart
    private static boolean canPlaceCows(int[] stalls, int k, int distance) {
        int count = 1; // Place the first cow in the first stall
        int lastPosition = stalls[0]; // Position of the last placed cow

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= distance) {
                count++; // Place another cow
                lastPosition = stalls[i]; // Update last position

                if (count == k) {
                    return true; // All cows placed successfully
                }
            }
        }

        return false; // Not enough space to place all cows
    }
}