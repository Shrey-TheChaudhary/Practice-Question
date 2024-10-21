//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    private static final int MOD = 1000000007;

    public static int countgroup(int arr[]) {
        int xorAll = 0;

        // Step 1: Compute XOR of all elements
        for (int num : arr) {
            xorAll ^= num;
        }

        // Step 2: If XOR of all elements is not zero, return 0
        if (xorAll != 0) {
            return 0;
        }

        // Step 3: If XOR is zero, calculate the result (2^(n-1) - 1) % MOD
        int n = arr.length;
        long result = 1;

        // Calculate 2^(n-1) % MOD
        for (int i = 0; i < n - 1; i++) {
            result = (result * 2) % MOD;
        }

        // Subtract 1 to exclude the case where all elements are in the same group
        result = (result - 1 + MOD) % MOD;

        return (int) result;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int ans = obj.countgroup(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends