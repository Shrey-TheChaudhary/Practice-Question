//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

import java.util.Arrays;

class Solution {
    long findSwapValues(long[] a, int n, long[] b, int m) {
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) sum1 += a[i];
        for (int i = 0; i < m; i++) sum2 += b[i];
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        if (sum1 < sum2) {
            int i = 0, j = m - 1;
            while (i < n && j >= 0 && b[j] - a[i] > 0) {
                long x = b[j] - a[i];
                if (sum1 + x == sum2 - x) return 1;
                i++;
                j--;
            }
        } else if (sum1 > sum2) {
            int i = 0, j = n - 1;
            while (i < m && j >= 0 && a[j] - b[i] > 0) {
                long x = a[j] - b[i];
                if (sum1 - x == sum2 + x) return 1;
                i++;
                j--;
            }
        }
        
        if (sum1 == sum2) return 1;
        return -1;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n = Integer.parseInt(q[0]);
            int m = Integer.parseInt(q[1]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            long b[] = new long[m];
            for (int i = 0; i < m; i++) {
                b[i] = Long.parseLong(a2[i]);
            }
            Solution ob = new Solution();
            long ans = ob.findSwapValues(a, n, b, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends