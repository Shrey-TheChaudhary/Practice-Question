//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            // Read the start times
            String[] startInput = reader.readLine().trim().split("\\s+");
            int[] start = new int[startInput.length];
            for (int i = 0; i < startInput.length; i++) {
                start[i] = Integer.parseInt(startInput[i]);
            }

            // Read the end times
            String[] endInput = reader.readLine().trim().split("\\s+");
            int[] finish = new int[endInput.length];
            for (int i = 0; i < endInput.length; i++) {
                finish[i] = Integer.parseInt(endInput[i]);
            }

            // Create solution object and call activitySelection
            Solution obj = new Solution();
            System.out.println(obj.activitySelection(start, finish));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    public int activitySelection(int[] start, int[] end) {
        // code here.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for (int i = 0; i < start.length; ++i)
            pq.offer(new int[] {start[i], end[i]});
        
        int cnt = 1;
        int ans = pq.peek()[1];
        
        while (!pq.isEmpty()) {
             if (pq.peek()[0] > ans) {
                cnt++;
                ans = pq.peek()[1];
            }
            pq.poll();
        }
        return cnt;
    }
}

