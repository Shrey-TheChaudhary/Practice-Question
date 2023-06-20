//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends



// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        
         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        int alp[] = new int[26];
        
        for(int i=0;i<s.length();i++)
            alp[s.charAt(i)-'a']++;
        
        for(int i=0;i<26;i++){
            if(alp[i] != 0){
            pq.add(alp[i]);
            }
        }
        while(k!=0){
            int remove = pq.poll();
            pq.add(remove - 1);
            k--;
        }
        int ans = 0;
        Iterator it = pq.iterator();
        while(it.hasNext()){
            int sq = (Integer)it.next();
            ans += (sq*sq);
        }
        return ans;
    }
}