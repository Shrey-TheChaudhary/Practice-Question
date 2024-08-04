//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int n, int start[], int end[]) {
        // add your code here
        int[][] ans = new int[n][2];
        
        for(int i = 0; i<n; i++){
            ans[i][0] = start[i];
            ans[i][1] = end[i];
        }
        
        Arrays.sort(ans, (a,b)->a[1]- b[1]);
        
        int s = ans[0][0];
        int c = 0;
        int e = ans[0][1];
        for(int i = 1; i<n; i++){
            if(ans[i][0] <= e){
                continue;
            }
            else{
                c++;
                e = ans[i][1];
            }
        }
        return c+1;
    }
}