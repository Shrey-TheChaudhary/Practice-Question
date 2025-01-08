//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
       Arrays.sort(arr);
        int n = arr.length;
        int res = 0;

        // Iterate over each element as the largest side of the triangle
        for (int i = n - 1; i >= 2; i--) {
            int j = i - 1;
            int k = 0;

            // Check pairs (arr[k], arr[j]) for each arr[i] as the largest side
            while (k < j) {
                // If arr[k] + arr[j] > arr[i], it forms a valid triangle
                if (arr[k] + arr[j] > arr[i]) {
                    // All pairs from k to j with arr[i] will form valid triangles
                    res += (j - k);
                    j--;  // Move j to the left
                } else {
                    k++;  // Move k to the right
                }
            }
        }
        // Return the total count of valid triangles
        return res;
    }
}