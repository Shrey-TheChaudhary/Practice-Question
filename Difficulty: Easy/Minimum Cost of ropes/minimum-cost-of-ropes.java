//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long[] a = new long[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Long.parseLong(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
         if (arr.length == 1) {
            return 0;
        }
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (long num : arr) {
            pq.offer(num);
        }
        
        long sum = 0;
        
        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();
            long curr = a + b;
            sum += curr;
            pq.offer(curr);
        }
        
        return sum;
    }
}