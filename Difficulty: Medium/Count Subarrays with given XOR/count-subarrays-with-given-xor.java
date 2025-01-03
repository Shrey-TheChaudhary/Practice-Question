//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
      HashMap<Integer, Integer> mp = new HashMap<>();
        int xor = 0; 
        long cnt = 0; 

        // Initialize the map for subarrays starting from the beginning
        mp.put(0, 1); 

        for (int a : arr) {
            xor = xor ^ a; // Update current XOR

            // Check if there's a prefix with XOR equal to (xor ^ k)
            if (mp.containsKey(xor ^ k)) {
                cnt += mp.get(xor ^ k); 
            }

            // Add the current XOR to the map
            mp.put(xor, mp.getOrDefault(xor, 0) + 1); 
        }

        return cnt; 
    }
}