//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String str) {
        // Code here
        int i = 0;
        int j = 0;
        int[] count = new int[3];
        int result = Integer.MAX_VALUE;
        
        while (j < str.length()) {
            count[str.charAt(j) - '0']++;
            while (count[0] >= 1 && count[1] >= 1 && count[2] >= 1) {
                int len = j - i + 1;
                result = Math.min(result, len);
                count[str.charAt(i) - '0']--;
                i++;
            }
            j++;
        }
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}