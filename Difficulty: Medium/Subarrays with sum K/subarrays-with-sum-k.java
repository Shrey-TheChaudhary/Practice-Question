//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
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
            int res = new Solution().countSubarrays(arr, k);

            System.out.print(res);
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int countSubarrays(int arr[], int k) {
        // HashMap to store the frequency of cumulative sums
        HashMap<Integer, Integer> sumCount = new HashMap<>();
        int currentSum = 0; // This will store the cumulative sum
        int count = 0; // This will store the number of subarrays with sum k
        
        // Initialize the hashmap with 0 sum having a count of 1
        sumCount.put(0, 1);
        
        // Iterate through the array
        for (int num : arr) {
            currentSum += num; // Update the cumulative sum
            
            // Check if (currentSum - k) exists in the hashmap
            if (sumCount.containsKey(currentSum - k)) {
                count += sumCount.get(currentSum - k); // Add the frequency of that sum to count
            }
            
            // Update the HashMap with the current cumulative sum
            sumCount.put(currentSum, sumCount.getOrDefault(currentSum, 0) + 1);
        }
        
        return count; // Return the total count of subarrays with sum k
    }
}