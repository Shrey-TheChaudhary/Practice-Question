//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // code here
        int m = meetings.length;
        int dp[] = new int[n];
        
        Arrays.sort(meetings , (a , b) -> a[0] - b[0]);
        PriorityQueue<Integer> room = new PriorityQueue<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        
        for(int i = 0; i < n; i++) {
            room.offer(i);
        }
        
        for(int i = 0; i < m; i++) {
            int s = meetings[i][0];
            int e = meetings[i][1];
            while(!pq.isEmpty() && pq.peek()[1] <= s) {
                int room_id = pq.poll()[0];
                room.offer(room_id);
            }
            int delay = 0;
            if(pq.size() == n) {
                delay = pq.peek()[1] - s;
                int room_id = pq.poll()[0];
                room.offer(room_id);
            }
            int room_id = room.poll();
            pq.offer(new int[]{room_id , e+delay});
            dp[room_id]++;
        }
        
        // System.out.println(Arrays.toString(dp));
        return getMaxRoomId(dp , n);
    }
    
    private int getMaxRoomId(int arr[], int n) {
        int max = 0;
        int room_id = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > max) {
                max = arr[i];
                room_id = i;
            }
        }
        return room_id;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends