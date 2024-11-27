//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // Read the line of integers (prices)
            String input = br.readLine().trim();

            // Split the input line into integers and store in an array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the missingNumber method
            int res = ob.missingNumber(arr);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the smallest positive number missing from the array.
     public int missingNumber(int[] arr) {
        // Your code here
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            pos=Math.max(arr[i],pos);
        }
        int arr1[] = new int[pos+1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                arr1[arr[i]] += 1;
            }
        }
        int mis = 1;
        for (int i = 0; i < arr1.length; i++) {
            if (i != 0) {
                if (arr1[i] == 0) {
                    return i;
                }
            }
        }
        return pos+1;
    }
}
