//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        Boolean t[][] = new Boolean[arr.length + 1][sum + 1];
        return solver(arr, 0, sum, arr.length, t);
    }

    static Boolean solver(int arr[], int i, int sum, int n, Boolean t[][]) {
        if (sum == 0) return true;
        if (i == n || sum < 0) return false;
        if (t[i][sum] != null) return t[i][sum]; 

        t[i][sum] = solver(arr, i + 1, sum - arr[i], n, t) || solver(arr, i + 1, sum, n, t);
        return t[i][sum];
    }
}