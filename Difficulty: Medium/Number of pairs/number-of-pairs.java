//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int x[] = new int[str.length];
            for (int i = 0; i < str.length; i++) x[i] = Integer.parseInt(str[i]);
            str = (br.readLine()).trim().split(" ");
            int[] y = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                y[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countPairs(x, y, x.length, y.length));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int x[], int y[], int M, int N) {
        // code here
        Arrays.sort(y);

        // Count of 0s, 1s, 2s, 3s, and 4s in y
        int[] count = new int[5];
        for (int i = 0; i < N; i++) {
            if (y[i] < 5) {
                count[y[i]]++;
            }
        }

        long totalPairs = 0;

        // Iterate over each element in x
        for (int i = 0; i < M; i++) {
            totalPairs += countPairsUtil(x[i], y, count, N);
        }

        return totalPairs;
    }

    private long countPairsUtil(int x, int[] y, int[] count, int N) {
        // If x is 0, no valid pairs
        if (x == 0) return 0;

        // If x is 1, count pairs with y = 0
        if (x == 1) return count[0];

        // Find the number of elements in y greater than x using binary search
        int idx = Arrays.binarySearch(y, x);
        if (idx < 0) {
            idx = Math.abs(idx + 1);
        } else {
            while (idx < N && y[idx] == x) {
                idx++;
            }
        }

        long totalPairs = N - idx;

        // Add pairs with y = 0 and y = 1
        totalPairs += count[0] + count[1];

        // Special cases for x = 2 and x = 3
        if (x == 2) {
            totalPairs -= (count[3] + count[4]);
        }
        if (x == 3) {
            totalPairs += count[2];
        }

        return totalPairs;
    }
}