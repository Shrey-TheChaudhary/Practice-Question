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
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int res = obj.maximumProfit(prices);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumProfit(int[] prices) {
        int res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Populate the TreeMap with prices and their frequencies
        for (int price : prices) {
            map.put(price, map.getOrDefault(price, 0) + 1);
        }

        // Iterate over the prices
        for (int i = 0; i < prices.length - 1; i++) {
            // Decrease the frequency of the current price
            map.put(prices[i], map.get(prices[i]) - 1);
            if (map.get(prices[i]) == 0) {
                map.remove(prices[i]); // Remove the price if its frequency becomes 0
            }

            // Check the maximum possible profit
            if (!map.isEmpty() && map.lastKey() >= prices[i]) {
                res = Math.max(map.lastKey() - prices[i], res);
            }
        }

        return res;
    }
}
