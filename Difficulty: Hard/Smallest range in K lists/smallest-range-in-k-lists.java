//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static class Node {
        int val, row, col;
        Node(int v, int r, int c) {
            val = v; row = r; col = c;
        }
    }
    
    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        // min-heap ordered by node.val
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int currentMax = Integer.MIN_VALUE;
        
        // Initialize: push first element of each row
        for (int i = 0; i < k; i++) {
            pq.offer(new Node(arr[i][0], i, 0));
            currentMax = Math.max(currentMax, arr[i][0]);
        }
        
        // Best range found so far
        int bestL = 0, bestR = Integer.MAX_VALUE;
        
        // Continue until one row is exhausted
        while (true) {
            Node mn = pq.poll();  // current minimum
            int currentMin = mn.val;
            
            // Update best range if tighter
            if (currentMax - currentMin < bestR - bestL) {
                bestL = currentMin;
                bestR = currentMax;
            }
            
            // Advance in the row that had the minimum
            if (mn.col + 1 == arr[mn.row].length) {
                // no more elements in this row → done
                break;
            }
            int nextVal = arr[mn.row][mn.col + 1];
            pq.offer(new Node(nextVal, mn.row, mn.col + 1));
            // update the running maximum
            if (nextVal > currentMax) {
                currentMax = nextVal;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(bestL);
        ans.add(bestR);
        return ans;
    }
}