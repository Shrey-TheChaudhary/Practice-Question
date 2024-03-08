//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    boolean sameFreq(String s) {
        if (s == null || s.isEmpty()) {
            return false; // Handle edge case where input string is null or empty
        }
        
        HashMap<Character, Long> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0L) + 1);
        }
        
        int count = 0;
        long val = hm.get(s.charAt(0));
        for (char ch : hm.keySet()) {
           // System.out.println(ch+" "+ hm.get(ch));
            if (hm.get(ch) != val && (int) Math.abs(val-hm.get(ch))>1) {
                return false;
            }
            else if(hm.get(ch)!=val)
            count++;
        }
        
        return count == 0 || count == 1;
    }
}