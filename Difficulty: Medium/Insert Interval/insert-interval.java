//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            int h[] = new int[2];
            h[0] = sc.nextInt();
            h[1] = sc.nextInt();
            sc.nextLine();
            Solution obj = new Solution();
            ArrayList<int[]> ans = obj.insertInterval(a, h);
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print("[");
                System.out.print(ans.get(i)[0] + "," + ans.get(i)[1]);
                System.out.print("]");
                if (i != ans.size() - 1) System.out.print(",");
            }
            System.out.println("]");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans=new ArrayList<>();
        int n=intervals.length;
        if(intervals[0][0]>newInterval[1]){
            // When the newInterval is the first non-overlapping interval
            ans.add(newInterval);
            for(int[] interval:intervals) ans.add(interval);
        }
        else{
            int st=newInterval[0];
            int end=newInterval[1];
            boolean added=false;
            for(int i=0;i<n;i++){
                int curSt=intervals[i][0];
                int curEnd=intervals[i][1];
// All possible overlaps: partial front, full and partial end.
                if((st<=curSt && end>=curSt) || (st<=curEnd && end>=curEnd)
 || (st>=curSt && end<=curEnd)){
                    if(!added){
                        // Add once
                        int minSt=Math.min(st,curSt);
                        int maxEnd=Math.max(end,curEnd);
                        ans.add(new int[]{minSt,maxEnd});
                        added=true;
                        st=minSt;
                        end=maxEnd;
                    }
                    else{
                        // Merge
                        int[] prev=ans.get(ans.size()-1);
                        int minSt=Math.min(prev[0],curSt);
                        int maxEnd=Math.max(prev[1],curEnd);
                        st=prev[0]=minSt;
                        end=prev[1]=maxEnd;
                    }
                }else if(!added && curSt>end){
                    // When no overlap
                    ans.add(newInterval);
                    ans.add(intervals[i]);
                    added=true;
                }
                else ans.add(intervals[i]);
            }
            // When the newInternal is the last non-overlapping interval
            if(!added) ans.add(newInterval);
        }
        return ans;
    }
}