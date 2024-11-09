//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String minSum(int[] arr) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(arr);

        // Step 2: Distribute digits alternately between two numbers
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                num1.append(arr[i]);
            } else {
                num2.append(arr[i]);
            }
        }

        // Step 3: Add the two numbers as strings and remove leading zeroes
        String result = addStrings(num1.toString(), num2.toString());
        
        // Remove leading zeroes
        return result.replaceFirst("^0+(?!$)", "");
    }
    
    // Method to add two numbers represented as strings
    private String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;

        // Add digits from the end of each string
        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j--) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }

        // Reverse the result to get the final answer
        return result.reverse().toString();
    }
}